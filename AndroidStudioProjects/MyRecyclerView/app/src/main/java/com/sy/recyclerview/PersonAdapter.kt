package com.sy.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sy.recyclerview.databinding.PersonItemBinding

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    var items = ArrayList<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item:Person){

            R.layout.text = item.name
            personItemBinding.output2.text = item.mobile
        }
    }
}