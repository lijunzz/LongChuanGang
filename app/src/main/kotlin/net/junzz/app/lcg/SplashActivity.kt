package net.junzz.app.lcg

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({ startActivity(Intent(this, MainActivity::class.java)) }, 3000)
    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}