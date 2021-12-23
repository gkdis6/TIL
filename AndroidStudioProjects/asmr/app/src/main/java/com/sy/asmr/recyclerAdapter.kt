package com.sy.asmr

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.sy.asmr.databinding.RecyclerViewItemBinding

class recyclerAdapter: RecyclerView.Adapter<Holder>() {
    private var mContext: Context? = null
    private lateinit var mp: MediaPlayer
    var Data = mutableListOf<Items>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        mContext = parent.context
        mp = MediaPlayer.create(mContext, R.raw.beat)
        val audio = mContext?.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audio.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        binding.button1.setOnClickListener {
            mp.start()
            mp.isLooping = true
        }
        binding.button2.setOnClickListener {
            mp.pause()
        }
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
    for (no in 1..5){
        val title = "음원${no}"
        val ipsum = "비${no}"
        val item = Items(title, ipsum, no)
        data.add(item)
    }
    return data
}