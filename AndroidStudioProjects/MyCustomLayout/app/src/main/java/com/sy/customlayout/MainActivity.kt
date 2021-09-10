package com.sy.customlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sy.customlayout.databinding.ActivityMainBinding
import com.sy.customlayout.databinding.Part1Binding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.
            output2.text = "010-0000-2222"
        }
    }
}