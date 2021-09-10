package com.example.asmr2


import android.widget.Toast
import android.os.Bundle
import com.example.asmr2.databinding.ActivityMainBinding
import com.sy.asmr.AsmrFragment
import com.sy.asmr.BaseActivity
import com.sy.asmr.Fragment1
import com.sy.asmr.FragmentAdapter

class MainActivity : BaseActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentList = listOf(Fragment1(), AsmrFragment())
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        binding.viewPager.adapter = adapter

    }

    override fun permissionGranted(requestCode: Int) {
        startProcess()
    }

    override fun permissionDenied(requestCode: Int) {
        Toast.makeText(this, "외부 저장소 권한을 승인해야 앱을 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
        finish()
    }

    fun startProcess() {

    }
}