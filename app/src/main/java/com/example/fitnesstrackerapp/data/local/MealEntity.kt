package com.example.fitnesstrackerapp.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal")
data class MealEntity(
    @PrimaryKey val id: String,
    val name: String,
    val calories: Int,
    val carbs: Int,
    val protein: Int,
    val fats: Int,
    val date: String
)