package com.arbems.recommendedapparchitecture

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey private val id: String,
    private val name: String,
    private val lastName: String
)