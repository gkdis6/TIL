package com.sy.contentresolver

import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sy.contentresolver.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class MusicRecyclerAdapter: RecyclerView.Adapter<MusicRecyclerAdapter.Holder>() {
    val musicList = mutableListOf<Music>()
    var mediaPlayer: MediaPlayer? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)

    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val music = musicList[position]
        holder.setMusic(music)
    }

    inner class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        var musicUri: Uri? = null

        init {
            binding.song.setOnClickListener{
                if (mediaPlayer != null){
                    mediaPlayer?.release()
                    mediaPlayer = null
                }
                mediaPlayer = MediaPlayer.create(binding.song.context, musicUri)
                mediaPlayer?.start()
            }
        }
        fun setMusic(music: Music) {
            binding.run {
                imageAlbum.setImageURI(music.getAlbumUri())
                textArtist.text = music.artist
                textTitle.text = music.title

                val duration = SimpleDateFormat("mm:ss").format(music.duration)
                textDuration.text = duration
            }
            this.musicUri = music.getMusicUri()
        }
    }
}