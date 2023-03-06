package com.route.islami_app.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.route.islami_app.R
import com.route.islami_app.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({ // start home activity after 2000 millis seconds
            startHomeActivity();
        }, 2000)
    }

    fun startHomeActivity() {
        val intent = Intent(this, HomeActivity()::class.java);
        startActivity(intent);
        finish();
    }
}