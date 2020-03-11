package com.missouristate.bryson.holoogram

import android.media.Image
import android.provider.ContactsContract
import java.util.*

data class User(var fullName: String, var userName: String, var email: ContactsContract.CommonDataKinds.Email, private var password: String) {
    lateinit var profileImage: Image
    lateinit var bio: String
    lateinit var work: String
    lateinit var school: String
    lateinit var contact: String
    lateinit var birthday: Date
    lateinit var phone: ContactsContract.CommonDataKinds.Phone
}