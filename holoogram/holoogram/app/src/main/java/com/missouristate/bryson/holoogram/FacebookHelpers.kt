package com.missouristate.bryson.holoogram

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import org.json.JSONObject
import java.net.URL


class FacebookHelpers {
    companion object Functions {
        lateinit var id: String
        lateinit var profilePicUrl: URL
        var profilePic: Bitmap? = null

        fun getFacebookData(jsonObject: JSONObject): Bundle? {
            val bundle = Bundle()
            id = jsonObject.getString("id")
            bundle.putString("FacebookID", id)
            profilePicUrl = URL("https://graph.facebook.com/$id/picture?type=large")
            bundle.putString(
                "profilePicUrl",
                profilePicUrl.toString()
            )
            if (jsonObject.has("first_name")) {
                bundle.putString("first_name", jsonObject.getString("first_name"))
            }
            if (jsonObject.has("last_name")) {
                bundle.putString("last_name", jsonObject.getString("last_name"))
            }
            if (jsonObject.has("email")) {
                bundle.putString("email", jsonObject.getString("email"))
            }
            if (jsonObject.has("gender")) {
                bundle.putString("gender", jsonObject.getString("gender"))
            }
            return bundle
        }

        fun getFacebookProfilePicture(): Bitmap? {
            ProfilePicCollector().execute()
            while (profilePic == null){}
            return profilePic
        }
    }
}