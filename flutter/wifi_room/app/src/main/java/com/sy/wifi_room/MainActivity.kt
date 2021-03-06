package com.sy.wifi_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.sy.wifi_room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}
    var helper: RoomHelper? = null


    companion object {
        const val TAG = "wifi_room"
        private const val PERMISSIONS_REQUEST_CODE_ACCESS_FINE_LOCATION = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        helper = Room.databaseBuilder(this, RoomHelper::class.java, "room_memo")
            .allowMainThreadQueries()
            .build()

        val adapter = RecyclerAdapter()
        adapter.helper = helper

        adapter.listData.addAll(helper?.roomMemoDao()?.getAll()?: listOf())
        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)

        binding.buttonSave.setOnClickListener {
            if(binding.editMemo.text.toString().isNotEmpty()){
                val memo = RoomMemo(binding.editMemo.text.toString(), Integer.parseInt(binding.editTextNumber.text.toString()), System.currentTimeMillis())
                helper?.roomMemoDao()?.insert(memo)
                adapter.listData.clear()
                adapter.listData.addAll(helper?.roomMemoDao()?.getAll()?: listOf())

                adapter.notifyDataSetChanged()
                binding.editMemo.setText("")
                binding.editTextNumber.setText("");
            }
        }



    }

}