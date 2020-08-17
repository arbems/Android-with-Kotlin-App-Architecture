package com.arbems.recommendedapparchitecture.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arbems.recommendedapparchitecture.data.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}