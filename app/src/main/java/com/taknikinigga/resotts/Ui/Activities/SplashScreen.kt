package com.taknikinigga.resotts.Ui.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = Handler()
        handler.postDelayed(Runnable {
           startActivity(Intent(this, Authentication::class.java))
            finish()
        },3000)

    }
}