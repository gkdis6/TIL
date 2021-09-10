package com.sy.visible

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.sy.visible.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK){
            when(requestCode){
                99 ->{
                    val message = data?.getStringExtra("returnValue")
                    if(message != "") {
                        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("from1", "Hello Bundle")
        intent.putExtra("from2", 2021)
        binding.button.setOnClickListener { startActivityForResult(intent, 99) }

        thread(start = true) {
            Thread.sleep(3000) //서브 스레드
            runOnUiThread {
                showProgrss(false) //메인 스레드
            }
        }



        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.seek.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }
    fun showProgrss(show: Boolean){
        if(show){
            binding.progressLayout.visibility = View.VISIBLE
        }else{
            binding.progressLayout.visibility = View.GONE
        }
    }
}