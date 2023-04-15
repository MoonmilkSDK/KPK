package com.example.mansrusyak

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    private var mName: EditText? = null
    private var mEmail: EditText? = null
    private var mPassword: EditText? = null

    lateinit var ref: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mName = findViewById(R.id.fullname)
        mEmail = findViewById(R.id.email)
        mPassword = findViewById(R.id.password)

        ref = getSharedPreferences("Myapp", MODE_PRIVATE)
    }

    fun signup(view: View) {
        val name = mName?.text.toString()
        val email = mEmail?.text.toString()
        val password = mPassword?.text.toString()

        ref.edit().putString("name", name).apply()
        ref.edit().putString("email", email).apply()
        ref.edit().putString("password", password).apply()

        ref.edit().putBoolean("login", true).apply()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}