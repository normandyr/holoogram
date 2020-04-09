package com.missouristate.bryson.holoogram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.facebook.HttpMethod
import org.json.JSONObject
import java.util.*

private const val AccessTokenForIntent = "Access Token"

private lateinit var currentUser: User
private lateinit var accessToken: AccessToken
private lateinit var request: GraphRequest

class HomepageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        //var accessToken = intent.getSerializableExtra(AccessTokenForIntent)
        /* make the API call */
        request = GraphRequest(
            AccessToken.getCurrentAccessToken(),
            "/{person-id}/",
            null,
            HttpMethod.GET,
            GraphRequest.Callback { /* handle the result */
                //TODO: Figure this crap out
            }
        )
        //request.executeAsync()
        request.executeAndWait()
    }
}
