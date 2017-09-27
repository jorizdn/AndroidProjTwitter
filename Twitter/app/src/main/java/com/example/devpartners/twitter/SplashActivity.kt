package com.example.devpartners.twitter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.devpartners.twitter.util.SessionStore
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast



class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        val postDelayed = Handler().postDelayed({

            val username = SessionStore().restoreEmail(this)
            if (username.isEmpty()){
                startActivity<LoginActivity>()
            }else{
                startActivity<HomeActivity>()
            }
            finish()
        }, 1000)
    }

}
