package com.missouristate.bryson.holoogram

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.facebook.login.LoginManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


private const val AccessTokenForIntent = "Access Token"

private lateinit var currentUser: User
private lateinit var facebookData: Bundle
private lateinit var jsonMap: Map<String, Any>
private lateinit var fullNameField: EditText
private lateinit var profilePic: ImageView
private lateinit var logoutButton: Button

class HomepageActivityA : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage_a)
    }

    override fun onStart(){
        super.onStart()
        jsonMap = Gson().fromJson(intent.getStringExtra("jsonString"), object : TypeToken<Map<String, Any>>() {}.type)
        facebookData = intent.getBundleExtra("facebookData")
        fullNameField = findViewById(R.id.editText_FullName_Homepage)
        fullNameField.setText(jsonMap["name"].toString())
        profilePic = findViewById(R.id.imageView_UserImage_Homepage)
        profilePic.setImageBitmap(intent.getParcelableExtra("profilePic") as Bitmap)
        logoutButton = findViewById(R.id.button_logout)

        logoutButton.setOnClickListener {
            LoginManager.getInstance().logOut()
            val intent = Intent(applicationContext, LoginActivityA::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
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
}