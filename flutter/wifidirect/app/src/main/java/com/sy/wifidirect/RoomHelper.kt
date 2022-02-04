package com.sy.wifidirect

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sy.wifidirect.RoomMemo
import com.sy.wifidirect.RoomMemoDao

@Database(entities = arrayOf(RoomMemo::class), version = 1, exportSchema = false)
abstract class RoomHelper: RoomDatabase() {
    abstract fun roomMemoDao(): RoomMemoDao
}