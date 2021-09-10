package com.sy.bthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sy.bthread.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var thread = WorkerThread()
        thread.start()

        var thread2 = Thread(WorkerRunnable())
        thread2.start()

        Thread{
            var i = 0
            while (i < 10){
                i += 1
                Log.i("LambdaThread","$i")
            }
        }.start()

        thread(start=true){
            var i = 0
            while(i<10){
                i += 1
                Log.i("KotlinThread", "$i")
            }
        }
        //여기까지 백그라운드 스레드
        //UI에 접근하여 binding에 값을 입력하려고 하면 FATAL EXCEPTION 예외를 발생시키고 앱이 종료됨
        //안드로이드 외에 윈도우와 ios앱도 메인 스레드만 UI를 업데이트 할 수 있다.

    }
}