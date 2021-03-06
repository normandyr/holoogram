package com.missouristate.bryson.holoogram

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private const val AccessTokenForIntent = "Access Token"

class MainActivity : AppCompatActivity() {
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        continueButton = findViewById(R.id.button_Continue_Main)
        continueButton.setOnClickListener{
            val intent = Intent(this@MainActivity, LayoutSelectorActivity::class.java)
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
