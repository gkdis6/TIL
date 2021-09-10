package com.sy.myinflater

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sy.myinflater.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            layoutInflater.inflate(R.layout.part1, binding.container, true)
        }
        binding.showButton.setOnClickListener {
            val showIntent = Intent(this, MenuActivity::class.java)
            showIntent.putExtra("mobile", "010--1000-1000")
            startActivityForResult(showIntent, 101)
        }
        binding.callButton.setOnClickListener {
            val mobileNum = binding.input2.text.toString()
            val callIntent = Uri.parse("tel:$mobileNum").let {
                    number -> Intent(Intent.ACTION_DIAL, number)}
            startActivity(callIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            101 -> {
                showToast("메뉴 액티비티에서 응답 받았음 : $requestCode, $resultCode")
                if(data != null){
                    processIntent(data)
                }
            }
        }
    }
    fun showToast(message:String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
    fun processIntent(passedIntent:Intent){
        val data = passedIntent.getStringExtra("data")
        data?.run{
            showToast("메뉴 엑티비티로부터 전달받은 데이터 : $data")
        }
    }
}