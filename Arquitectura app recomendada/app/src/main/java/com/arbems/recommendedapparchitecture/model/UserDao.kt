package com.arbems.recommendedapparchitecture.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.arbems.recommendedapparchitecture.data.User

@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    fun save(user: User)

    @Query("SELECT * FROM user WHERE id = :userId")
    fun load(userId: String): LiveData<User>
}