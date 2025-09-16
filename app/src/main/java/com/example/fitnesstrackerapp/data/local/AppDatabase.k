package com.example.fitnesstrackerapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitnesstrackerapp.data.local.entities.UserEntity
import com.example.fitnesstrackerapp.data.local.entities.WorkoutEntity
import com.example.fitnesstrackerapp.data.local.entities.MealEntity

@Database(entities = [UserEntity::class, WorkoutEntity::class, MealEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun workoutDao(): WorkoutDao
    abstract fun mealDao(): MealDao
}