package com.sy.visible

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sy.visible.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class CustomAdapter: RecyclerView.Adapter<Holder>() { //345p
    var listData = mutableListOf<Memo>()
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}
class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root){
    fun setMemo(memo: Memo){
        binding.textNo.text = "${memo.no}"
        binding.Title.text = memo.title

        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(memo.timestamp)
        binding.textDate.text = formattedDate
    }

    init{
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "클릭된 아이템 = ${binding.Title.text}", Toast.LENGTH_LONG).show()
        }
    }
}