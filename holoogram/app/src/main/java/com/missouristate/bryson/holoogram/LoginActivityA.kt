package com.missouristate.bryson.holoogram

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.AccessToken
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

private const val AccessTokenForIntent = "Access Token"

class LoginActivityA : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var createAccountButton: Button
    private lateinit var facebookButton: Button
    private lateinit var callbackManager: CallbackManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_a)
        //requestedorientation is only used for the video view.  We will need
        //to wait until we have a class activity for that view to implement the expression
        //below but I wanted to shwo that we had it ready to go when needed
        //requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        loginButton = findViewById(R.id.LoginID)
        createAccountButton = findViewById(R.id.CreateActID)
        facebookButton = findViewById(R.id.button_login_Facebook)

        loginButton.setOnClickListener{
            // TODO: Handle login logic
            // Has temporary response
            //val intent = Intent(this, HomepageActivity::class.java)
            //startActivity(intent)
            Toast.makeText(this, "Database login not available, log in via Facebook instead", Toast.LENGTH_SHORT).show()
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
                handleLoginStuff()
            }

            override fun onCancel() { // App code
            }

            override fun onError(exception: FacebookException) { // App code
            }
        })
    }

    override fun onStart() {
        super.onStart()
        handleLoginStuff()
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.contact_us_a_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.contact -> {
                val intent = Intent(this, ContactUsActivityA::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }

    fun handleLoginStuff() {
        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired
        if (isLoggedIn) {
            val intent = Intent(this@LoginActivityA, HomepageActivityA::class.java)
            var request: GraphRequest = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken()
            ) { jsonObject, response ->
                intent.putExtra("facebookData", FacebookHelpers.getFacebookData(jsonObject))
                intent.putExtra("jsonString", jsonObject.toString())
                intent.putExtra("profilePic", FacebookHelpers.getFacebookProfilePicture())
                startActivity(intent)
            }
            request.executeAsync()
        }
    }
}
