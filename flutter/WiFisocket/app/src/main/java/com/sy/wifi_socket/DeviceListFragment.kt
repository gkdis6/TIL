package com.sy.wifi_socket

import android.net.wifi.p2p.*
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DeviceListFragment : Fragment(), WifiP2pManager.PeerListListener{

    private val peers: MutableList<WifiP2pDevice> = ArrayList()
    private var device: WifiP2pDevice? = null

    companion object{
        private fun getDeviceStatus(deviceStatus: Int): String?{
            Log.d("WiFi-socket", "Peer status :$deviceStatus")
            return when(deviceStatus){
                WifiP2pDevice.AVAILABLE -> "Available"
                WifiP2pDevice.INVITED -> "Invited"
                WifiP2pDevice.CONNECTED -> "Connected"
                WifiP2pDevice.FAILED -> "Failed"
                WifiP2pDevice.UNAVAILABLE -> "Unavailable"
                else -> "Unknown"
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.device_list, container, false)
    }

    fun updateThisDevice(device: WifiP2pDevice) {
        this.device = device
        getDeviceStatus(device.status)
    }


    override fun onPeersAvailable(peerList: WifiP2pDeviceList) {
        peers.clear()
        peers.addAll(peerList.deviceList)
        if(peers.size == 0){
            Log.d("WiFi-socket", "No devices found")
            return
        }
    }

    interface DeviceActionListener{
        fun showDetails(device: WifiP2pDevice?)
        fun cancelDisconnect()
        fun connect(config:WifiP2pConfig?)
        fun disconnect()
    }

}