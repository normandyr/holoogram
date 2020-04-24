package com.missouristate.bryson.holoogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button

class LayoutSelectorActivity : AppCompatActivity() {
    lateinit var access_btn: Button
    lateinit var normal_btn: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestedorientation is only used for the video view.  We will need
        //to wait until we have a class activity for that view to implement the expression
        //below but I wanted to shwo that we had it ready to go when needed
        //requestedOrientation =  (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_layout_select)

        access_btn = findViewById(R.id.access)
        normal_btn = findViewById(R.id.normal)

        access_btn.setOnClickListener {
            val intent = Intent(this, LoginActivityA::class.java)
            startActivity(intent)

        }

        normal_btn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
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
                val intent = Intent(this, ContactUsActivity::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }
}