package com.sy.mediaplayer_test

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.sy.mediaplayer_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mp: MediaPlayer
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val audio = this.getSystemService(Context.AUDIO_SERVICE) as AudioManager

        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                audio.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        mp = MediaPlayer.create(this, R.raw.beat)
        binding.buttonPlay.setOnClickListener {
            mp.start()
            mp.isLooping = true
        }
        binding.buttonPause.setOnClickListener {
            mp.pause()
        }

    }
}