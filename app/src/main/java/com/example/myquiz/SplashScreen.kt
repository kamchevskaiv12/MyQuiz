package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val btnGo: Button =findViewById(R.id.btnGo)

        btnGo.setOnClickListener {
            var intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }
}