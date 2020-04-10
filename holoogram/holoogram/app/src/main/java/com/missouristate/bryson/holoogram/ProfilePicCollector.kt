package com.missouristate.bryson.holoogram

import android.graphics.BitmapFactory
import android.os.AsyncTask
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class ProfilePicCollector() : AsyncTask<Void?, Void?, Void?>() {
    override fun doInBackground(vararg params: Void?): Void? {
        var urlConnection: HttpURLConnection? = null
        try {
            val url = URL("https://reqres.in/api/users?page=2")
            urlConnection = url.openConnection() as HttpURLConnection
            val code: Int = urlConnection.responseCode
            if (code != 200) {
                throw IOException("Invalid response from server: $code")
            }
            FacebookHelpers.profilePic = BitmapFactory.decodeStream(FacebookHelpers.profilePicUrl.openConnection().getInputStream())
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            urlConnection?.disconnect()
        }
        return null
    }
}