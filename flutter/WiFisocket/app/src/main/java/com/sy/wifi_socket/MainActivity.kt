package com.sy.wifi_socket

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.net.wifi.WpsInfo
import android.net.wifi.p2p.WifiP2pConfig
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager
import android.os.*
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sy.wifi_socket.databinding.ActivityMainBinding
import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.*

class MainActivity : AppCompatActivity(), WifiP2pManager.ChannelListener {

    companion object {
        var socket = Socket()
        var server = ServerSocket()
        lateinit var writeSocket: DataOutputStream
        lateinit var readSocket: DataInputStream
        lateinit var cManager: ConnectivityManager
        private const val PERMISSIONS_REQUEST_CODE_ACCESS_FINE_LOCATION = 1001
        private const val TAG = "WiFi-socket"

        var ip = "192.168.0.1"
        var port = 2222
        var mHandler = Handler()
        var closed = false
    }

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var isWifiP2pEnabled = false
    private val intentFilter = IntentFilter()
    private var channel: WifiP2pManager.Channel? = null
    private var manager: WifiP2pManager? = null
    private var retryChannel = false
    private var receiver: BroadcastReceiver? = null
    private var becomeClient = false
    private var device: WifiP2pDevice? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        cManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        server.close()
        socket.close()

        // manager.removeGroup(channel,null);
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)

        //WiFi P2p initialize
        if (!initP2p()) {
            finish()
        }

        //권한 요청
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
            && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_CODE_ACCESS_FINE_LOCATION
            )
        }

        //Wifi P2p 연결 후 서버로부터 받은 ip주소로 소켓에 연결(Client에서 눌러야 하는 버튼)
        binding.buttonConnect.setOnClickListener {    //클라이언트 -> 서버 접속
            val config = WifiP2pConfig()
            becomeClient = true
            config.deviceAddress = device!!.deviceAddress
            config.wps.setup = WpsInfo.PBC
            (MainActivity as DeviceListFragment.DeviceActionListener?)?.connect(config)
        }

        //WiFi P2p의 연결을 끊는 버튼
        binding.buttonDisconnect.setOnClickListener {    //클라이언트 -> 서버 접속 끊기
            if (!socket.isClosed) {
                Disconnect().start()
            } else {
                Toast.makeText(this@MainActivity, "서버와 연결이 되어있지 않습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        //사용되지 않음
        binding.buttonSetserver.setOnClickListener {    //서버 포트 열기
            if (binding.etPort.text.isNotEmpty()) {
                val cport = binding.etPort.text.toString().toInt()
                if (cport < 0 || cport > 65535) {
                    Toast.makeText(
                        this@MainActivity,
                        "PORT 번호는 0부터 65535까지만 가능합니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (server.isClosed) {
                        port = cport
                        SetServer().start()
                    } else {
                        val tstr = port.toString() + "번 포트가 열려있습니다."
                        Toast.makeText(this@MainActivity, tstr, Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this@MainActivity, "PORT 번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        //서버가 정상적으로 닫히지 않고있음
        binding.buttonCloseserver.setOnClickListener {    //서버 포트 닫기
            if (!server.isClosed) {
                CloseServer().start()
            } else {
                mHandler.obtainMessage(17).apply {
                    sendToTarget()
                }
            }
        }

        //discoverPeers 하는 버튼 WiFiDirectBroadcastReceiver의 intent필터를 통해 requestPeer로 연결됨
        binding.buttonDiscover.setOnClickListener {    //자기자신의 연결 정보(IP 주소)확인
            if (!isWifiP2pEnabled) {
                Toast.makeText(
                    this@MainActivity, "P2P를 활성화시켜주세요",
                    Toast.LENGTH_SHORT
                ).show()
            }
            manager!!.discoverPeers(channel, object : WifiP2pManager.ActionListener {
                override fun onSuccess() {
                    Toast.makeText(
                        this@MainActivity, "탐색 시작",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onFailure(reasonCode: Int) {
                    Toast.makeText(
                        this@MainActivity, "탐색 실패 : $:reasonCode",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
        }

        //메세지를 보내는 버튼
        binding.buttonMsg.setOnClickListener {    //상대에게 메시지 전송
            if (socket.isClosed) {
                Toast.makeText(this@MainActivity, "연결이 되어있지 않습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val mThread = SendMessage()
                mThread.setMsg(binding.etMsg.text.toString())
                mThread.start()
            }
        }

        //Thread로부터 서버나 소켓의 연결상태를 수신받는 핸들러
        mHandler = object : Handler(Looper.getMainLooper()) {  //Thread들로부터 Handler를 통해 메시지를 수신
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                when (msg.what) {
                    1 -> Toast.makeText(
                        this@MainActivity,
                        "IP 주소가 잘못되었거나 서버의 포트가 개방되지 않았습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                    2 -> Toast.makeText(
                        this@MainActivity,
                        "서버 포트 " + port + "가 준비되었습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                    3 -> Toast.makeText(this@MainActivity, msg.obj.toString(), Toast.LENGTH_SHORT)
                        .show()
                    4 -> Toast.makeText(this@MainActivity, "연결이 종료되었습니다.", Toast.LENGTH_SHORT)
                        .show()
                    5 -> Toast.makeText(this@MainActivity, "이미 사용중인 포트입니다.", Toast.LENGTH_SHORT)
                        .show()
                    6 -> Toast.makeText(this@MainActivity, "서버 준비에 실패하였습니다.", Toast.LENGTH_SHORT)
                        .show()
                    7 -> Toast.makeText(this@MainActivity, "서버가 종료되었습니다.", Toast.LENGTH_SHORT)
                        .show()
                    8 -> Toast.makeText(
                        this@MainActivity,
                        "서버가 정상적으로 닫히는데 실패하였습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                    9 -> binding.textStatus.text = msg.obj as String
                    11 -> Toast.makeText(this@MainActivity, "서버에 접속하였습니다.", Toast.LENGTH_SHORT)
                        .show()
                    12 -> Toast.makeText(this@MainActivity, "메시지 전송에 실패하였습니다.", Toast.LENGTH_SHORT)
                        .show()
                    13 -> Toast.makeText(this@MainActivity, "클라이언트와 연결되었습니다.", Toast.LENGTH_SHORT)
                        .show()
                    14 -> Toast.makeText(this@MainActivity, "서버에서 응답이 없습니다.", Toast.LENGTH_SHORT)
                        .show()
                    15 -> Toast.makeText(this@MainActivity, "서버와의 연결을 종료합니다.", Toast.LENGTH_SHORT)
                        .show()
                    16 -> Toast.makeText(
                        this@MainActivity,
                        "클라이언트와의 연결을 종료합니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                    17 -> Toast.makeText(this@MainActivity, "포트가 이미 닫혀있습니다.", Toast.LENGTH_SHORT)
                        .show()
                    18 -> Toast.makeText(this@MainActivity, "서버와의 연결이 끊어졌습니다.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    //server ip주소를 수신받은 후에 clinet가 server ip주소로 연결신청
    //지정된 포트와 ip의 소켓이 열렸는지 Listen
    //ClientSocket도 호출
    class Connect : Thread() {

        override fun run() {
            try {
                socket = Socket(ip, port)
                writeSocket = DataOutputStream(socket.getOutputStream())
                readSocket = DataInputStream(socket.getInputStream())
                val b = readSocket.read()
                if (b == 1) {    //서버로부터 접속이 확인되었을 때
                    mHandler.obtainMessage(11).apply {
                        sendToTarget()
                    }
                    ClientSocket().start()
                } else {    //서버 접속에 성공하였으나 서버가 응답을 하지 않았을 때
                    mHandler.obtainMessage(14).apply {
                        sendToTarget()
                    }
                    socket.close()
                }
            } catch (e: Exception) {    //연결 실패
                val state = 1
                mHandler.obtainMessage(state).apply {
                    sendToTarget()
                }
                socket.close()
            }

        }
    }

    //연결된 소켓으로부터 메세지가 수신되는지 listen하고 메세지가 수신되면 handler로 보내 toast해줌
    class ClientSocket : Thread() {
        override fun run() {
            try {
                while (true) {
                    val ac = readSocket.read()
                    if (ac == 2) {    //서버로부터 메시지 수신 명령을 받았을 때
                        val bac = readSocket.readUTF()
                        val input = bac.toString()
                        val recvInput = input.trim()

                        val msg = mHandler.obtainMessage()
                        msg.what = 3
                        msg.obj = recvInput
                        mHandler.sendMessage(msg)
                    } else if (ac == 10) {    //서버로부터 접속 종료 명령을 받았을 때
                        mHandler.obtainMessage(18).apply {
                            sendToTarget()
                        }
                        socket.close()
                        break
                    }
                }
            } catch (e: SocketException) {    //소켓이 닫혔을 때
                mHandler.obtainMessage(15).apply {
                    sendToTarget()
                }
            }
        }
    }

    class Disconnect : Thread() {
        override fun run() {
            try {
                writeSocket.write(10)    //서버에게 접속 종료 명령 전송
                socket.close()
            } catch (e: Exception) {

            }
        }
    }

    //지정된 포트로 소켓 연결 후 수신되는 메세지가 있는지 Listen
    class SetServer : Thread() {

        override fun run() {
            try {
                server = ServerSocket(port)    //포트 개방
                mHandler.obtainMessage(2, "").apply {
                    sendToTarget()
                }

                while (true) {
                    socket = server.accept()
                    writeSocket = DataOutputStream(socket.getOutputStream())
                    readSocket = DataInputStream(socket.getInputStream())

                    writeSocket.write(1)    //클라이언트에게 서버의 소켓 생성을 알림
                    mHandler.obtainMessage(13).apply {
                        sendToTarget()
                    }
                    while (true) {
                        val ac = readSocket.read()
                        if (ac == 10) {    //클라이언트로부터 소켓 종료 명령 수신
                            mHandler.obtainMessage(16).apply {
                                sendToTarget()
                            }
                            break
                        } else if (ac == 2) {    //클라이언트로부터 메시지 전송 명령 수신
                            val bac = readSocket.readUTF()
                            val input = bac.toString()
                            val recvInput = input.trim()

                            val msg = mHandler.obtainMessage()
                            msg.what = 3
                            msg.obj = recvInput
                            mHandler.sendMessage(msg)    //핸들러에게 클라이언트로 전달받은 메시지 전송
                        }
                    }
                }

            } catch (e: BindException) {    //이미 개방된 포트를 개방하려 시도하였을때
                mHandler.obtainMessage(5).apply {
                    sendToTarget()
                }
            } catch (e: SocketException) {    //소켓이 닫혔을 때
                mHandler.obtainMessage(7).apply {
                    sendToTarget()
                }
            } catch (e: Exception) {
                if (!closed) {
                    mHandler.obtainMessage(6).apply {
                        sendToTarget()
                    }
                } else {
                    closed = false
                }
            }
        }
    }

    class CloseServer : Thread() {
        override fun run() {
            try {
                closed = true
                writeSocket.write(10)    //클라이언트에게 서버가 종료되었음을 알림
                socket.close()
                server.close()
            } catch (e: Exception) {
                e.printStackTrace()
                mHandler.obtainMessage(8).apply {
                    sendToTarget()
                }
            }
        }
    }

    class SendMessage : Thread() {
        private lateinit var msg: String

        fun setMsg(m: String) {
            msg = m
        }

        override fun run() {
            try {
                writeSocket.writeInt(2)    //메시지 전송 명령 전송
                writeSocket.writeUTF(msg)    //메시지 내용
            } catch (e: Exception) {
                e.printStackTrace()
                mHandler.obtainMessage(12).apply {
                    sendToTarget()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(
            receiver, intentFilter
        )
        Log.d("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
        Log.d("Lifecycle", "onPause")
    }

    class ShowInfo : Thread() {

        override fun run() {
            lateinit var ip: String
            var breakLoop = false
            val en = NetworkInterface.getNetworkInterfaces()
            while (en.hasMoreElements()) {
                val intf = en.nextElement()
                val enumIpAddr = intf.inetAddresses
                while (enumIpAddr.hasMoreElements()) {
                    val inetAddress = enumIpAddr.nextElement()
                    if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                        ip = inetAddress.hostAddress.toString()
                        breakLoop = true
                        break
                    }
                }
                if (breakLoop) {
                    break
                }
            }

            val msg = mHandler.obtainMessage()
            msg.what = 9
            msg.obj = ip
            mHandler.sendMessage(msg)
        }
    }

    fun setIsWifiP2pEnabled(isWifiP2pEnabled: Boolean) {
        this.isWifiP2pEnabled = isWifiP2pEnabled
    }

    private fun initP2p(): Boolean {
        // Device capability definition check
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_WIFI_DIRECT)) {
            Log.e(
                TAG,
                "Wi-Fi Direct is not supported by this device."
            )
            return false
        }

        // Hardware capability check
        val wifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        if (wifiManager == null) {
            Log.e(
                TAG,
                "Cannot get Wi-Fi system service."
            )
            return false
        }
        if (!wifiManager.isP2pSupported) {
            Log.e(
                TAG,
                "Wi-Fi Direct is not supported by the hardware or Wi-Fi is off."
            )
            return false
        }
        manager = getSystemService(WIFI_P2P_SERVICE) as WifiP2pManager
        if (manager == null) {
            Log.e(
                TAG,
                "Cannot get Wi-Fi Direct system service."
            )
            return false
        }
        channel = manager!!.initialize(this, mainLooper, null)
        channel?.also { channel ->
            receiver = WiFiDirectBroadcastReceiver(manager, channel, this)
        }
        if (channel == null) {
            Log.e(
                TAG,
                "Cannot initialize Wi-Fi Direct."
            )
            return false
        }
        return true
    }

    override fun onChannelDisconnected() {
        // we will try once more
        if (manager != null && !retryChannel) {
            Toast.makeText(this, "Channel lost. Trying again", Toast.LENGTH_LONG).show()
            retryChannel = true
            manager!!.initialize(this, mainLooper, this)
        } else {
            Toast.makeText(
                this,
                "Severe! Channel is probably lost permanently. Try Disable/Re-Enable P2P.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}