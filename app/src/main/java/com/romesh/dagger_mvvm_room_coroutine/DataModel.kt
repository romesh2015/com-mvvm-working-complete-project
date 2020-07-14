package com.romesh.dagger_mvvm_room_coroutine

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class DataModel(
        val page : Int,
        val per_page : Int,
        val total: Int,
        val total_pages : Int,
        val data : List<Users>
):Serializable
@Entity(tableName = "Users")
data class Users(
        @PrimaryKey val id: Int,
        val first_name:String,
        val last_name:String,
        val avatar:String
)