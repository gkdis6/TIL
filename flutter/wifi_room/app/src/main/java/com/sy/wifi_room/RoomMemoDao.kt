package com.sy.wifi_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

//Data Access Object. DML쿼리를 실행하는 메서드의 모음
@Dao
interface RoomMemoDao {
    @Query("select * from room_memo")
    fun getAll(): List<RoomMemo>

    @Insert(onConflict = REPLACE)
    fun insert(memo: RoomMemo)

    @Delete
    fun delete(memo: RoomMemo)

    @Query("UPDATE room_memo set quantity = :quantity WHERE no = :no")
    fun update(quantity: Int?, no: Long?)
}


