package com.sy.myinflater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sy.myinflater.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    val binding by lazy { ActivityMenuBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.backButton.setOnClickListener {
            val backIntent = Intent()
            backIntent.putExtra("data", "홍길동")
            setResult(201, backIntent)
            finish()
        }
        if (intent != null) {
            processIntent(intent)
        }


    }
    fun processIntent(passedIntent: Intent){
        val mobile = passedIntent.getStringExtra("mobile")
        if (mobile != null){
            showToast("전달받은 값 : $mobile")
        }
        /*
        mobile?.run{
            showToast("전달받은 값 : $mobile")
        }
        */
    }
    fun showToast(message:String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}