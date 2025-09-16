package com.example.fitnesstrackerapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fitnesstrackerapp.data.local.entities.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserById(id: String): UserEntity?
}