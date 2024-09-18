package com.example.flashlightcontroller

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Context
import android.os.Handler
import android.os.HandlerThread
import android.widget.Toast
import java.io.IOException
import java.io.OutputStream
import java.util.UUID

class BluetoothHandler(private val context: Context) {
    private val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    private var bluetoothSocket: BluetoothSocket? = null
    private var outputStream: OutputStream? = null
    private val handlerThread: HandlerThread = HandlerThread("BluetoothHandlerThread").apply { start() }
    private val handler: Handler = Handler(handlerThread.looper)
    var isConnected = false // Connection flag

    private var currentDevice: BluetoothDevice? = null // Track the current connected device
    private var retryAttempts = 0 // Retry counter

    val pairedDevices: Set<BluetoothDevice>
        get() = bluetoothAdapter.bondedDevices

    // Connect to the selected Bluetooth device
    fun connectToDevice(device: BluetoothDevice) {
        currentDevice = device // Store the connected device
        Toast.makeText(context, "Connecting to ${device.name}", Toast.LENGTH_SHORT).show()

        handler.post {
            try {
                closeConnection() // Ensure any existing connection is closed before starting a new one
                bluetoothSocket = device.createRfcommSocketToServiceRecord(HC05_UUID)
                bluetoothSocket?.connect() // Blocking call, handled on background thread

                outputStream = bluetoothSocket?.outputStream
                isConnected = true
                retryAttempts = 0 // Reset retry attempts on successful connection
                showToastOnUi("Connected to ${device.name}")
            } catch (e: IOException) {
                isConnected = false
                e.printStackTrace()
                showToastOnUi("Failed to connect to ${device.name}. Retrying...")
                retryConnection() // Retry connection
            }
        }
    }

    // Retry Bluetooth connection with limited attempts
    private fun retryConnection() {
        if (currentDevice != null && retryAttempts < 5) { // Limit retries to 5 attempts
            retryAttempts++
            handler.postDelayed({
                showToastOnUi("Reconnecting to ${currentDevice?.name} (Attempt $retryAttempts)...")
                connectToDevice(currentDevice!!) // Try reconnecting to the device
            }, 3000) // Wait 3 seconds before retrying
        } else {
            showToastOnUi("Failed to reconnect after $retryAttempts attempts.")
        }
    }

    // Method to send Bluetooth commands asynchronously
    fun sendBluetoothCommand(command: String) {
        if (isConnected && outputStream != null) {
            handler.post {
                try {
                    outputStream?.write(command.toByteArray())
                    outputStream?.flush()
                } catch (e: IOException) {
                    isConnected = false
                    e.printStackTrace()
                    showToastOnUi("Connection lost. Trying to reconnect...")
                    retryConnection() // Attempt to reconnect if sending fails
                }
            }
        } else {
            showToastOnUi("Device not connected. Please connect and try again.")
        }
    }

    // Validate message content to avoid unsupported characters
    fun validateMessage(message: String): Boolean {
        return message.matches("[a-zA-Z0-9.,? ]+".toRegex())
    }

    // Close Bluetooth connection and release resources
    fun closeConnection() {
        try {
            bluetoothSocket?.close() // Close the socket to ensure it's properly released
            outputStream = null
            bluetoothSocket = null
            isConnected = false
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    // Utility method to show Toast on the main thread
    private fun showToastOnUi(message: String) {
        (context as? MainActivity)?.runOnUiThread {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private val HC05_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    }
}
