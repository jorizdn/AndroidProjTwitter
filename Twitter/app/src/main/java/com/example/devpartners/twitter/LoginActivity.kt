package com.example.devpartners.twitter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Html
import com.example.devpartners.twitter.util.SessionStore
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        var username = usernameEdit.text
        var password = passwordEdit.text.toString()

        forgotText.setText(Html.fromHtml("<u>" + forgotText.text + "</u>"));

        loginButton.setOnClickListener {
           if (validate(usernameEdit.text.toString(), passwordEdit.text.toString())) {
               startActivity<HomeActivity>()
               val store = SessionStore()
               store.saveEmail(usernameEdit.text.toString(), this)
               finish() }else{
               toast("A Fraud!")
           }
       }
}

    private fun validate(username:String, password:String) :Boolean{
        if (username.equals("jorizDn") && password.equals("gogo")){
            return true
        }
        return false
    }
}
