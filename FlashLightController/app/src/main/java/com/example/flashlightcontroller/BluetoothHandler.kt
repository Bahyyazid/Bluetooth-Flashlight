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
    var isConnected = false
    private var currentDevice: BluetoothDevice? = null
    private var retryAttempts = 0

    val pairedDevices: Set<BluetoothDevice>
        get() = bluetoothAdapter.bondedDevices

    fun connectToDevice(device: BluetoothDevice) {
        currentDevice = device
        Toast.makeText(context, "Connecting to ${device.name}", Toast.LENGTH_SHORT).show()

        handler.post {
            try {
                closeConnection()
                bluetoothSocket = device.createRfcommSocketToServiceRecord(HC05_UUID)
                bluetoothSocket?.connect()

                outputStream = bluetoothSocket?.outputStream
                isConnected = true
                retryAttempts = 0
                showToastOnUi("Connected to ${device.name}")
            } catch (e: IOException) {
                isConnected = false
                e.printStackTrace()
                showToastOnUi("Failed to connect to ${device.name}. Retrying...")
                retryConnection()
            }
        }
    }

    private fun retryConnection() {
        if (currentDevice != null && retryAttempts < 5) {
            retryAttempts++
            handler.postDelayed({
                showToastOnUi("Reconnecting to ${currentDevice?.name} (Attempt $retryAttempts)...")
                connectToDevice(currentDevice!!)
            }, 3000)
        } else {
            showToastOnUi("Failed to reconnect after $retryAttempts attempts.")
        }
    }

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
                    retryConnection()
                }
            }
        } else {
            showToastOnUi("Device not connected. Please connect and try again.")
        }
    }

    fun validateMessage(message: String): Boolean {
        return message.matches("[a-zA-Z0-9.,? ]+".toRegex())
    }

    fun closeConnection() {
        try {
            bluetoothSocket?.close()
            outputStream = null
            bluetoothSocket = null
            isConnected = false
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun showToastOnUi(message: String) {
        (context as? MainActivity)?.runOnUiThread {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private val HC05_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")
    }
}
