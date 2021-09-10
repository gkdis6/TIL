package com.sy.calc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sy.calc2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

}