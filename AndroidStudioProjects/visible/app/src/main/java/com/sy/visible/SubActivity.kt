package com.sy.visible

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sy.visible.databinding.ActivitySubBinding
import com.sy.visible.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class SubActivity : AppCompatActivity() {
    val binding by lazy {ActivitySubBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.to1.text = intent.getStringExtra("from1")
        binding.to2.text = "${intent.getIntExtra("from2", 0)}"

        binding.btnClose.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("returnValue", binding.input1.text.toString())
            setResult(RESULT_OK, returnIntent)
            finish()
        }
        val data = listOf("선택하세요", "1월", "2월", "3월", "4월", "5월", "6월")
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.result.text = data.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        fun loadData(): MutableList<Memo>{
            val data: MutableList<Memo> = mutableListOf()
            for(no in 1..100){
                val title = "이것이 안드로이드다 ${no}"
                val date = System.currentTimeMillis()
                var memo = Memo(no, title, date)
                data.add(memo)
            }
            return data
        }
        val data2:MutableList<Memo> = loadData()
        var adapter2 = CustomAdapter()
        adapter2.listData = data2
        binding.recyclerView.adapter = adapter2
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
