package com.missouristate.bryson.holoogram

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.AccessToken
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

private const val AccessTokenForIntent = "Access Token"

class MainActivity : AppCompatActivity() {
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        continueButton = findViewById(R.id.button_Continue_Main)
        continueButton.setOnClickListener{
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
