package com.sy.wifi_socket

import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pInfo
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.Executors

class DeviceDetailFragment : Fragment(), WifiP2pManager.ConnectionInfoListener {
    private var info: WifiP2pInfo? = null
    private var device: WifiP2pDevice? = null
    private var clientIP: String? = null
    private var becomeClient = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.device_detail, container, false)
    }

    override fun onConnectionInfoAvailable(info: WifiP2pInfo?) {
        this.info = info
        if(!becomeClient && !info!!.isGroupOwner){
            sendServerIPToGroupOwnerClient()
        }else if(becomeClient && info!!.isGroupOwner){
            getServerIpFromGroupMemberServer()
        }
    }

    private fun getServerIpFromGroupMemberServer() {
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        executor.execute {
            try{
                val serverSocket = ServerSocket(8987)
                serverSocket.reuseAddress = true
                val client = serverSocket.accept()
                val inputStream = client.getInputStream()
                val objectInputStream = ObjectInputStream(inputStream)
                clientIP = client.inetAddress.hostAddress
                inputStream.close()
                serverSocket.close()
            }catch (e: IOException){
                e.printStackTrace()
            }
            handler.post{
                Toast.makeText(
                    activity, "Clinet IP is : $clientIP", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun sendServerIPToGroupOwnerClient(){
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        executor.execute {
            val SOCKET_TIMEOUT = 5000
            val socket = Socket()
            try{
                socket.bind(null)
                socket.reuseAddress = true
                socket.connect(
                    InetSocketAddress(
                        info!!.groupOwnerAddress.hostAddress,
                        8987
                    ), SOCKET_TIMEOUT
                )
                val outputStream = socket.getOutputStream()
                val objectOutputStream = ObjectOutputStream(outputStream)
                objectOutputStream.writeInt(4)
            }catch(e: IOException){
                e.printStackTrace()
            }
            handler.post{
                Toast.makeText(
                    activity,"Fetching Client IP",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}