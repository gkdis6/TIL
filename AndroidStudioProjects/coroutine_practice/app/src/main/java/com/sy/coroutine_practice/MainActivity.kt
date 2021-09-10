package com.sy.coroutine_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sy.coroutine_practice.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*
        GlobalScope.launch {

        }
        binding.btnDownload.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{

            }
        }
        */

        //cancel을 사용하면 스코프 안에 여러 개의 코루틴이 있으면 하위의 코루틴도 모두 동작을 멈춤
        //job 안에 job1 이런 식으로 있을 경우 job을 멈추면 job1도 같이 멈춤
        /* val job = CoroutineScope(Dispatchers.Default).launch {
            val job1 = launch {
                for(i in 0..10){
                    delay(500)
                    Log.d("코루틴", "결과 = $i")
                }
            }
        }
        binding.btnStop.setOnClickListener{
            job.cancel()
        } */


        //join을 사용하면 join이 실행이 완료된 후에 두 번째 코루틴이 실행됨
        /* CoroutineScope(Dispatchers.Default).launch {
            launch {
                for (i in 0..5){
                    delay(500)
                    Log.d("코루틴", "결과1 = $i")
                }
            }.join()

            launch {
                for (i in 0..5){
                    delay(500)
                    Log.d("코루틴", "결과2 = $i")
                }
            }
        } */

        //async, await
        CoroutineScope(Dispatchers.Default).async {
            val deferred1 = async {
                delay(500)
                350
            }
            val deferred2 = async {
                delay(1000)
                200
            }
            Log.d("코루틴", "연산 결과 = ${deferred1.await() + deferred2.await()}")
        }

        //suspend
        //suspend를 사용하면 suspend를 먼저 처리한 후 다음 코드가 실행됨
        suspend fun subRoutine(){
            for (i in 0..10){
                Log.d("subRoutine", "$i")
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            //(코드1)
            subRoutine()
            //(코드2)
            //코드1이 실행되고 suspend를 사용했기 때문에 subRoutine듸 코드가 모두 실행된 후 코드2가 실행됨
        }

        //withContext는 스코프에서 suspend를 호출할 때 다른 Dispatchers를 사용해야 할 때 사
        suspend fun readFile(): String{
            return "파일 내용"
        }
        CoroutineScope(Dispatchers.Main).launch {
            //화면 처리
            val result = withContext(Dispatchers.IO){
                readFile()
            }
            Log.d("코루틴", "파일 결과 = $result")
        }

    }
}