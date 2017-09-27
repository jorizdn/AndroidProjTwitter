package com.example.devpartners.twitter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.devpartners.twitter.util.SessionStore
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()
        helloText.setText("Hello " + SessionStore().restoreEmail(this) + " XD")

        logoutButton.setOnClickListener{
            val store = SessionStore()
            store.clearEmail(this)
            if(store.restoreEmail(this).isEmpty()){
                startActivity<LoginActivity>()
                finish()
            }else{
                toast("Error Logging out!")
            }
        }

    }
}
