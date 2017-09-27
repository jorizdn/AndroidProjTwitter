package com.example.devpartners.twitter.util

/**
 * Created by DEV PARTNERS on 9/25/2017.
 */
import  android.content.Context
import  android.content.SharedPreferences
import java.security.Key

class SessionStore{
    var KEY_USER_EMAIL = "email"

    fun saveEmail(email : String, context: Context){
        val editor = context.getSharedPreferences(KEY_USER_EMAIL, Context.MODE_PRIVATE).edit()

        editor.putString(KEY_USER_EMAIL, email)
        editor.apply()
    }

    fun restoreEmail(context: Context) : String{
        val prefs = context.getSharedPreferences(KEY_USER_EMAIL, Context.MODE_PRIVATE)

        return  prefs.getString(KEY_USER_EMAIL, "")
    }

    fun clearEmail(context: Context){
        val editor = context.getSharedPreferences(KEY_USER_EMAIL, Context.MODE_PRIVATE).edit()

        editor.clear()
        editor.apply()
    }
}