package com.missouristate.bryson.holoogram

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.AccessToken
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

private const val AccessTokenForIntent = "Access Token"

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var createAccountButton: Button
    private lateinit var facebookButton: Button
    private lateinit var callbackManager: CallbackManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //requestedorientation is only used for the video view.  We will need
        //to wait until we have a class activity for that view to implement the expression
        //below but I wanted to shwo that we had it ready to go when needed
        //requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        loginButton = findViewById(R.id.button_AttemptLogin_Main)
        createAccountButton = findViewById(R.id.button_CreateAccount_Main)
        facebookButton = findViewById(R.id.button_login_Facebook)

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

        FacebookSdk.sdkInitialize(applicationContext)
        //AppEventsLogger.activateApp(this)


        callbackManager = CallbackManager.Factory.create()

        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
            override fun onSuccess(loginResult: LoginResult?) { // App code
                val accessToken = AccessToken.getCurrentAccessToken()
                val isLoggedIn = accessToken != null && !accessToken.isExpired
                if (isLoggedIn) {
                    val intent = Intent(this@MainActivity, HomepageActivity::class.java)
                    intent.putExtra(AccessTokenForIntent, accessToken)
                    startActivity(intent)
                }
            }

            override fun onCancel() { // App code
            }

            override fun onError(exception: FacebookException) { // App code
            }
        })
    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
