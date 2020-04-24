package com.missouristate.bryson.holoogram

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ContactUsActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_a)
    }

    fun sendEmail(v: View) {
        var userName: String = findViewById<EditText>(R.id.editText).text.toString()
        val mailto = "mailto:bryson.atom@gmail.com" +
                "?cc=" + "" +
                "&subject=" + Uri.encode("Support Needed") +
                "&body=" + Uri.encode("From: $userName")

        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.type = "text/plain";
        emailIntent.type = "message/rfc822"
        emailIntent.data = Uri.parse(mailto)

        try {
            startActivity(emailIntent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No email clients installed.", Toast.LENGTH_SHORT).show()
        }


    }
}