package com.sy.wifi_room

import android.R
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sy.wifi_room.databinding.ActivityChatBinding
import com.sy.wifi_room.databinding.ActivityMainBinding
import java.io.*
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import java.net.UnknownHostException


class ChatActivity : AppCompatActivity() {
    private var serverSocket: ServerSocket? = null
    var updateConversationHandler: Handler? = null
    var serverThread: Thread? = null
    private var socket: Socket? = null
//    var receivedText: TextView? = null
//    var yourMessage: EditText? = null
//    var send: Button? = null
    var owner = false

    private val binding by lazy{ ActivityChatBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = intent
        owner = intent.getBooleanExtra("Owner?", false)
        SERVER_IP = intent.getStringExtra("Owner Address")
//        receivedText = findViewById<View>(R.id.text_incoming) as TextView
//        yourMessage = findViewById<View>(R.id.text_send) as EditText
//        send = findViewById<View>(R.id.btn_send) as Button
//        updateConversationHandler = Handler()

        // If we're the owner start a server, else connect to the server
        if (owner) {
            serverThread = Thread(ServerThread())
            serverThread!!.start()
        } else {
            Thread(ClientThread()).start()
        }

        // Sends the text to the server
        binding.btnSend.setOnClickListener {
            if(binding.textSend.text.isNotEmpty()) {
                val str = binding.textSend!!.text
                val out = PrintWriter(
                    BufferedWriter(
                        OutputStreamWriter(
                            socket?.getOutputStream()
                        )
                    ), true
                )
                out.println(str)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        try {
            serverSocket?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    // Opens a socket on the owner device to get messages
    internal inner class ServerThread : Runnable {
        override fun run() {
            var socket: Socket? = null
            try {
                // Create a socket on port 6000
                serverSocket = ServerSocket(SERVERPORT)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            while (!Thread.currentThread().isInterrupted) {
                try {
                    // Start listening for messages
                    socket = serverSocket?.accept()
                    val commThread: CommunicationThread = CommunicationThread(socket!!)
                    Thread(commThread).start()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }

    // Handles received messages from clients
    internal inner class CommunicationThread(clientSocket: Socket) : Runnable {
        private val clientSocket: Socket
        private var input: BufferedReader? = null
        override fun run() {
            while (!Thread.currentThread().isInterrupted) {
                try {
                    val read: String = input!!.readLine()
                    updateConversationHandler!!.post(UpdateUIThread(read))
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

        init {
            this.clientSocket = clientSocket
            try {
                // read received data
                input = BufferedReader(InputStreamReader(this.clientSocket.getInputStream()))
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    // Handles showing received messages on screen
    internal inner class UpdateUIThread(private val msg: String) : Runnable {
        // Print message on screen
        override fun run() {
            binding.textIncoming!!.text = """
                 ${binding.textIncoming!!.text}Gelen Mesaj: $msg
                 
                 """.trimIndent()
        }
    }

    // Handles connection to server
    internal inner class ClientThread : Runnable {
        override fun run() {
            try {
                val serverAddress: InetAddress = InetAddress.getByName(SERVER_IP)
                socket = Socket(serverAddress, SERVERPORT)
            } catch (e: UnknownHostException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        const val SERVERPORT = 6000
        private var SERVER_IP: String? = null
    }
}
