package com.sy.servicetest

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    val binder = MyBinder()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action
        Log.d("StartedService", "action = $action")
        return super.onStartCommand(intent, flags, startId)
    }

    companion object {
        val ACTION_START = "com.sy.servicetest.START"
        val ACTION_RUN = "com.sy.servicetest.RUN"
        val ACTION_STOP = "com.sy.servicetext.STOP"
    }

    override fun onDestroy() {
        Log.d("Service", "서비스가 종료되었습니다.")
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    inner class MyBinder: Binder(){
        fun getService(): MyService{
            return this@MyService
        }
    }

    fun serviceMessage():String{
        return "Hello Activity! I am Service!"
    }
}
