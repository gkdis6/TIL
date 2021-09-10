package com.sy.basic4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.sy.basic4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val input1 = binding.input1.text.toString()
            val pref = getSharedPreferences("pref", MODE_PRIVATE)
            //pref.edit().putString("userName", input1).commit()
            pref.edit {
                putString("userName", input1)
                //putString("userName2", input2)
                commit()
            }
        }
        binding.button2.setOnClickListener {
            val pref = getSharedPreferences("pref", MODE_PRIVATE)
            val userName = pref.getString("userName", "")//값이 없을 경우 디폴트값을 뱉음
            binding.input1.setText(userName)
        }
    }
}