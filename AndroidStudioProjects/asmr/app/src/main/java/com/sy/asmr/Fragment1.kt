package com.sy.asmr

import android.os.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.sy.asmr.databinding.Fragment1Binding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread

class Fragment1 : Fragment() {
    lateinit var binding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("a h:mm:ss")
        val formatted = current.format(formatter)
        binding.textTime.text = formatted

        thread(start = true) {
            while (true) {
                Thread.sleep(1000)
                handler?.sendEmptyMessage(0)
            }
        }


    }

    @RequiresApi(Build.VERSION_CODES.O)
    val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("a h:mm:ss")
            val formatted = current.format(formatter)
            binding.textTime.text = formatted
        }
    }
}