package com.example.flashlightcontroller

import android.bluetooth.BluetoothDevice
import android.os.Bundle
import android.util.SparseArray
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {
    private var textInput: EditText? = null
    private val pairedDevicesList: MutableList<BluetoothDevice> = ArrayList()
    private var bluetoothHandler: BluetoothHandler? = null
    private var connectButton: ImageButton? = null
    private var pairedDevicesDialog: AlertDialog? = null
    private val buttonCommandMap = SparseArray<String>()
    private var isMinButtonPressed = false
    private var isPlusButtonPressed = false
    private val handler = Handler(Looper.getMainLooper())
    private val connectionCheckRunnable = object : Runnable {
        override fun run() {
            checkBluetoothConnectionStatus()
            handler.postDelayed(this, 3000)
        }
    }

    private val buttonClickListenerCommand = View.OnClickListener { v: View ->
        val command = buttonCommandMap[v.id]
        if (command != null) {
            bluetoothHandler?.sendBluetoothCommand(command)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = resources.getColor(android.R.color.black, null)

        bluetoothHandler = BluetoothHandler(this)
        textInput = findViewById(R.id.TextInput)
        connectButton = findViewById(R.id.ConnectButton)

        buttonCommandMap.put(R.id.MinButton, "<")
        buttonCommandMap.put(R.id.PlusButton, ">")
        buttonCommandMap.put(R.id.ModeSelect, "#")
        buttonCommandMap.put(R.id.OutputSelect, "@")
        buttonCommandMap.put(R.id.StopButton, "*")
        buttonCommandMap.put(R.id.SpeedSelect, "^")

        setupButton(R.id.MinButton)
        setupButton(R.id.PlusButton)
        setupButton(R.id.ModeSelect)
        setupButton(R.id.OutputSelect)
        setupButton(R.id.StopButton)
        setupButton(R.id.SpeedSelect)

        FunctionalButton(R.id.SendButton)
        FunctionalButton(R.id.ConnectButton)

        setupLoopButton(R.id.BrightnessMin, R.id.MinButton)
        setupLoopButton(R.id.BrightnessPlus, R.id.PlusButton)

        val sendButton = findViewById<ImageButton>(R.id.SendButton)
        sendButton.setOnClickListener {
            val message = textInput?.text.toString().trim()
            if (bluetoothHandler?.validateMessage(message) == true) {
                bluetoothHandler?.sendBluetoothCommand(message)
                textInput?.setText("")
            } else {
                Toast.makeText(this, "Invalid characters in the message.", Toast.LENGTH_SHORT).show()
            }
        }

        connectButton?.setOnClickListener { displayPairedDevices() }

        handler.post(connectionCheckRunnable)
    }

    private fun setupButton(buttonId: Int) {
        val button = findViewById<ImageButton>(buttonId)
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> v.alpha = 0.2f
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.alpha = 1.0f
            }
            false
        }
        button.setOnClickListener(buttonClickListenerCommand)
    }

    private fun FunctionalButton(buttonId: Int) {
        val button = findViewById<ImageButton>(buttonId)
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> v.alpha = 0.2f
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> v.alpha = 1.0f
            }
            false
        }
    }

    private fun setupLoopButton(buttonId: Int, targetButtonId: Int) {
        val button = findViewById<ImageButton>(buttonId)
        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.alpha = 0.2f
                    startCommandLoop(targetButtonId)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.alpha = 1.0f
                    stopCommandLoop(targetButtonId)
                }
            }
            true
        }
    }

    private fun startCommandLoop(targetButtonId: Int) {
        val command = buttonCommandMap[targetButtonId] ?: return

        when (targetButtonId) {
            R.id.MinButton -> {
                isMinButtonPressed = true
                Thread {
                    while (isMinButtonPressed) {
                        bluetoothHandler?.sendBluetoothCommand(command)
                        Thread.sleep(100)
                    }
                }.start()
            }
            R.id.PlusButton -> {
                isPlusButtonPressed = true
                Thread {
                    while (isPlusButtonPressed) {
                        bluetoothHandler?.sendBluetoothCommand(command)
                        Thread.sleep(100)
                    }
                }.start()
            }
        }
    }

    private fun stopCommandLoop(targetButtonId: Int) {
        when (targetButtonId) {
            R.id.MinButton -> isMinButtonPressed = false
            R.id.PlusButton -> isPlusButtonPressed = false
        }
    }

    private fun displayPairedDevices() {
        val pairedDevices = bluetoothHandler?.pairedDevices ?: emptyList()
        pairedDevicesList.clear()

        if (pairedDevices.isNotEmpty()) {
            pairedDevicesList.addAll(pairedDevices)
        } else {
            Toast.makeText(this, "No paired devices found.", Toast.LENGTH_SHORT).show()
        }

        val listViewPairedDevices = ListView(this)
        val adapter = DeviceAdapter()
        listViewPairedDevices.adapter = adapter

        listViewPairedDevices.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedDevice = pairedDevicesList[position]
            bluetoothHandler?.connectToDevice(selectedDevice)
        }

        val builder = AlertDialog.Builder(this)
        builder.setView(listViewPairedDevices)
        pairedDevicesDialog = builder.show()
    }

    private fun checkBluetoothConnectionStatus() {
        if (bluetoothHandler?.isConnected == true) {
            connectButton?.setImageResource(R.drawable.connecteds)
            pairedDevicesDialog?.dismiss()
        } else {
            connectButton?.setImageResource(R.drawable.connect)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bluetoothHandler?.closeConnection()
        handler.removeCallbacks(connectionCheckRunnable)
    }

    private inner class DeviceAdapter : BaseAdapter() {
        override fun getCount(): Int = pairedDevicesList.size

        override fun getItem(position: Int): Any = pairedDevicesList[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: layoutInflater.inflate(R.layout.list_item_device, parent, false)
            val textView = view.findViewById<TextView>(R.id.device_name)
            val device = pairedDevicesList[position]
            textView.text = device.name
            return view
        }
    }
}
