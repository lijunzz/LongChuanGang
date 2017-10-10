package net.junzz.app.lcg

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatDelegate

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 使用夜间模式
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        // 使设置生效
        recreate()
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