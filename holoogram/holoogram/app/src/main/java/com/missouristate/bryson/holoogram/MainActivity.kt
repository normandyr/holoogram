package com.missouristate.bryson.holoogram

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.video.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestedorientation is only used for the video view.  We will need
        //to wait until we have a class activity for that view to implement the expression
        //below but I wanted to shwo that we had it ready to go when needed
        //requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.signup)
    }
}
