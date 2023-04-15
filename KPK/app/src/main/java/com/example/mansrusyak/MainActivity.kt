package com.example.mansrusyak

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {

    private var mName: TextView? = null
    private var mEmail: TextView? = null
    lateinit var ref: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setContentView(R.layout.activity_main)

        mName = findViewById(R.id.name)
        mEmail = findViewById(R.id.email)
        ref = getSharedPreferences("Myapp", MODE_PRIVATE)
        mName?.text = ref.getString("name", "")
        mEmail?.text = ref.getString("email", "")

        val btnTeachers = findViewById<Button>(R.id.buttonTeachers)
        val btnGroups = findViewById<Button>(R.id.buttonGroups)
        val logoutBtn = findViewById<Button>(R.id.logout)
        btnTeachers.setOnClickListener {
            val intent = Intent(this,TeacherActivity::class.java)
            startActivity(intent)
        }
        btnGroups.setOnClickListener {
            val intent = Intent(this,GroupActivity::class.java)
            startActivity(intent)
        }

        logoutBtn.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        ref.edit().putBoolean("login", false).apply()
        startLogin()

    }

    private fun startLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}