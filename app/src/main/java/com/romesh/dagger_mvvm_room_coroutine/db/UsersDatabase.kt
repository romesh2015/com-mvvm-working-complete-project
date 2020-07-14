package com.romesh.dagger_mvvm_room_coroutine.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.romesh.dagger_mvvm_room_coroutine.Users

@Database(entities = [(Users::class)], version = 1)
abstract class UsersDatabase : RoomDatabase(){

    abstract fun usersDao() : UsersDao
}