package com.missouristate.bryson.holoogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SignupActivity : AppCompatActivity() {
    private lateinit var signupButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        signupButton = findViewById(R.id.button_AttemptSignUp_SignUp)

        signupButton.setOnClickListener{
            Toast.makeText(this, "Not available right now", Toast.LENGTH_SHORT).show()
        }
    }
}
