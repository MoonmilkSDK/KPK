package com.example.mansrusyak

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class LoginActivity : AppCompatActivity() {

    private var mEmail: EditText? = null
    private var mPassword: EditText? = null
    lateinit var ref: SharedPreferences


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setContentView(R.layout.activity_login)

        mEmail = findViewById(R.id.email)
        mPassword = findViewById(R.id.password)

        ref = getSharedPreferences("Myapp", MODE_PRIVATE)

        val check = ref.getBoolean("login", false)
        if(check){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("NotConstructor")
    fun Login(view: View) {
        val sEmail = ref.getString("email", "")
        val sPassword = ref.getString("password", "")
        if(sEmail.equals(mEmail?.text.toString()) && sPassword.equals(mPassword?.text.toString())){
            ref.edit().putBoolean("login", true).apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show()
        }
    }
    fun goToSignup(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}