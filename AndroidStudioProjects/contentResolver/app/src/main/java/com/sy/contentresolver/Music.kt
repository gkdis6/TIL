package com.sy.contentresolver

import android.net.Uri
import android.provider.MediaStore

class Music(id:String, title:String?, artist:String?, albumId:String?, duration:Long?) {
    var id: String = "" //음원 자체의 id
    var title: String?
    var artist: String?
    var albumId: String?  //앨범명, 앨범이미지를 위해
    var duration: Long?

    init{
        this.id = id
        this.title = title
        this.artist = artist
        this.albumId = albumId
        this.duration = duration
    }

    fun getMusicUri(): Uri {
        return Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id)
    }

    fun getAlbumUri(): Uri {
        return Uri.parse("content://media/external/audio/albumart/" + (albumId?:0) )
    }
}