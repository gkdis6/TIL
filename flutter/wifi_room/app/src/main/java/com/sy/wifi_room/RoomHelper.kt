package com.sy.wifi_room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sy.wifi_room.RoomMemo
import com.sy.wifi_room.RoomMemoDao

@Database(entities = arrayOf(RoomMemo::class), version = 1, exportSchema = false)
abstract class RoomHelper: RoomDatabase() {
    abstract fun roomMemoDao(): RoomMemoDao
}