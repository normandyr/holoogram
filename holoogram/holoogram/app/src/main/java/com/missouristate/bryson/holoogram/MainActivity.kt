package com.missouristate.bryson.holoogram

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.video.*

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var createAccountButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //requestedorientation is only used for the video view.  We will need
        //to wait until we have a class activity for that view to implement the expression
        //below but I wanted to shwo that we had it ready to go when needed
        //requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        loginButton = findViewById(R.id.button_AttemptLogin_Main)
        createAccountButton = findViewById(R.id.button_CreateAccount_Main)

        loginButton.setOnClickListener{
            // TODO: Handle login logic
            // Has temporary response
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
        }

        createAccountButton.setOnClickListener{
            // TODO: Handle account creation logic
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
