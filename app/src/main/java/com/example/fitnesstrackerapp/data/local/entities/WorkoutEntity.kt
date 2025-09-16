package com.example.fitnesstrackerapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout")
data class WorkoutEntity(
    @PrimaryKey val id: String,
    val type: String,
    val durationMinutes: Int,
    val caloriesBurned: Int,
    val date: String
)