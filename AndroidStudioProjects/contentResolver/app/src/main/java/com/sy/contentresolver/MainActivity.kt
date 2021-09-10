package com.sy.contentresolver

import android.Manifest
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sy.contentresolver.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        requirePermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 999)
    }

    override fun permissionGranted(requestCode: Int){
        startProcess()
    }

    override fun permissionDenied(requestCode: Int){
        Toast.makeText(this, "외부 저장소 권한을 승인해야 앱을 사용할 수 있습니다.", Toast.LENGTH_LONG).show()
        finish()
    }

    fun startProcess() {

        val adapter = MusicRecyclerAdapter()
        adapter.musicList.addAll(getMusicList())

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun getMusicList(): List<Music> {
        // 컨텐트 리졸버로 음원 목록 가져오기
        // 1. 데이터 테이블 주소
        val listUrl = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        // 2. 가져올 데이터 컬럼 정의
        val proj = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media.DURATION,
        )
        // 3. 컨텐트 리졸버에 해당 데이터 요청
        val cursor = contentResolver.query(listUrl, proj, null, null, null)
        // 4. 커서로 전달받은 데이터를 꺼내서 저장
        val musicList = mutableListOf<Music>()
        while (cursor?.moveToNext() == true) {
            val id = cursor.getString(0)
            val title = cursor.getString(1)
            val artist = cursor.getString(2)
            val albumId = cursor.getString(3)
            val duration = cursor.getLong(4)

            val music = Music(id, title, artist, albumId, duration)
            musicList.add(music)
        }
        return musicList
    }


}