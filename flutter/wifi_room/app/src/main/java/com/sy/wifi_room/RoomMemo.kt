package com.sy.wifi_room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_memo")
class RoomMemo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var no: Long? = null

    @ColumnInfo
    var content: String = ""

    @ColumnInfo
    var quantity: Int? =null

    @ColumnInfo(name = "date")
    var datetime: Long = 0

    constructor(content:String, quantity: Int, datetime: Long){
        this.content = content
        this.quantity = quantity
        this.datetime = datetime
    }
}