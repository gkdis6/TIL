package com.sy.wifi_socket

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.NetworkInfo
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager
import android.os.Parcelable
import androidx.core.app.ActivityCompat

class WiFiDirectBroadcastReceiver (
    private val manager: WifiP2pManager?,
    private val channel: WifiP2pManager.Channel,
    private val activity: MainActivity
): BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent) {
        val action: String? = intent.action
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        when(action){
            WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION ->{
                val state = intent?.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1)
                if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                    // Wifi Direct mode is enabled
                    activity.setIsWifiP2pEnabled(true)
                } else {
                    activity.setIsWifiP2pEnabled(false)
                }
            }
            WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION ->{
                manager?.requestPeers(
                    channel, activity.fragmentManager.findFragmentById(R.id.fragment_list) as WifiP2pManager.PeerListListener
                )
            }
            WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION ->{
                if (manager == null) {
                    return
                }
                val networkInfo = intent
                    ?.getParcelableExtra<Parcelable>(WifiP2pManager.EXTRA_NETWORK_INFO) as NetworkInfo?
                if (networkInfo!!.isConnected) {

                    // we are connected with the other device, request connection
                    // info to find group owner IP
                        val fragment = activity.fragmentManager.findFragmentById(R.id.fragment_detail) as DeviceDetailFragment
                    manager.requestConnectionInfo(
                        channel,
                        fragment
                    )
                }
            }
            WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION ->{

            }
        }
    }

}