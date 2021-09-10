package com.sy.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sy.recyclerview.databinding.ActivityMainBinding
import com.sy.recyclerview.databinding.PersonItemBinding

class MainActivity : AppCompatActivity() {

    val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    val personItemBinding = PersonItemBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        activityMainBinding.recyclerView.layoutManager = layoutManager

        val adapter = PersonAdapter()

        adapter.items.add(Person("홍길동1", "010-3333-2222"))
        adapter.items.add(Person("홍길동2", "010-1111-2222"))
        adapter.items.add(Person("홍길동3", "010-4444-2222"))

        activityMainBinding.recyclerView.adapter = adapter
    }
}