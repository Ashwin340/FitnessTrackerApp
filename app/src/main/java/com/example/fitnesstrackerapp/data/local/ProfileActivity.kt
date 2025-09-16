package com.example.fitnesstrackerapp.profile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.fitnesstrackerapp.R
import com.example.fitnesstrackerapp.data.local.AppDatabase
import com.example.fitnesstrackerapp.data.local.entities.UserEntity
import java.util.*

class ProfileActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "fitness-tracker-db"
        ).build()

        val nameEdit = findViewById<EditText>(R.id.editTextName)
        val ageEdit = findViewById<EditText>(R.id.editTextAge)
        val heightEdit = findViewById<EditText>(R.id.editTextHeight)
        val weightEdit = findViewById<EditText>(R.id.editTextWeight)
        val activityEdit = findViewById<EditText>(R.id.editTextActivityLevel)
        val saveButton = findViewById<Button>(R.id.buttonSaveProfile)

        saveButton.setOnClickListener {
            val user = UserEntity(
                id = UUID.randomUUID().toString(),
                name = nameEdit.text.toString(),
                age = ageEdit.text.toString().toInt(),
                heightCm = heightEdit.text.toString().toInt(),
                weightKg = weightEdit.text.toString().toInt(),
                activityLevel = activityEdit.text.toString()
            )

            Thread {
                db.userDao().insertUser(user)
                runOnUiThread {
                    Toast.makeText(this, "Profile Saved", Toast.LENGTH_SHORT).show()
                }
            }.start()
        }
    }
}