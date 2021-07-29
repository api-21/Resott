package com.taknikinigga.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.taknikinigga.myapplication.auth.MobileAuthFragment
import kotlinx.android.synthetic.main.app_bar_layout.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = Handler()
        handler.postDelayed(Runnable {
           startActivity(Intent(this,Authentication::class.java))
            finish()

        },3000)


    }
}