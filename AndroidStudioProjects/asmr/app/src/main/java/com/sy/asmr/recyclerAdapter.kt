package com.sy.asmr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sy.asmr.databinding.RecyclerViewItemBinding

class recyclerAdapter: RecyclerView.Adapter<Holder>() {
    var Data = mutableListOf<Items>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = Data.get(position)
        holder.setItem(item)
    }

    override fun getItemCount(): Int {
        return Data.size
    }


}

class Holder(val binding: RecyclerViewItemBinding): RecyclerView.ViewHolder(binding.root){
    fun setItem(item: Items){
        binding.button1.text = "${item.title}"
        binding.button2.text = "${item.ipsum}"
    }
    init{
        binding.button1.setOnClickListener {
            binding.button1.visibility = View.GONE
            binding.button2.visibility = View.VISIBLE
            binding.seekBar.visibility = View.VISIBLE
        }
        binding.button2.setOnClickListener {
            binding.button1.visibility = View.VISIBLE
            binding.button2.visibility = View.GONE
            binding.seekBar.visibility = View.GONE
        }
    }
}

fun loadData():MutableList<Items>{
    val data: MutableList<Items> = mutableListOf()
    for (no in 1..8){
        val title = "음원${no}"
        val ipsum = "비${no}"
        val item = Items(title, ipsum)
        data.add(item)
    }
    return data
}