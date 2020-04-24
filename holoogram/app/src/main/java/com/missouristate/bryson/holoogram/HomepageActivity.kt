package com.missouristate.bryson.holoogram

import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.missouristate.bryson.holoogram.FacebookHelpers.Functions.getFacebookProfilePicture


private const val AccessTokenForIntent = "Access Token"

private lateinit var currentUser: User
private lateinit var facebookData: Bundle
private lateinit var jsonMap: Map<String, Any>
private lateinit var fullNameField: EditText
private lateinit var profilePic: ImageView

class HomepageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
    }

    override fun onStart(){
        super.onStart()
        jsonMap = Gson().fromJson(intent.getStringExtra("jsonString"), object : TypeToken<Map<String, Any>>() {}.type)
        facebookData = intent.getBundleExtra("facebookData")
        fullNameField = findViewById(R.id.editText_FullName_Homepage)
        fullNameField.setText(jsonMap["name"].toString())
        profilePic = findViewById(R.id.imageView_UserImage_Homepage)
        profilePic.setImageBitmap(intent.getParcelableExtra("profilePic") as Bitmap)
    }
}
