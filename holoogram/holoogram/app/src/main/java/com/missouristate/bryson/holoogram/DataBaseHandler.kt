package com.missouristate.bryson.holoogram

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHandler(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int): SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    companion object {
        var DATABASE_NAME = "user_database"
        private val DATABASE_VERSION = 1
        private const val TABLE_USERS = "users"
        private const val KEY_ID = "id"
        private const val FULL_NAME = "full_name"
        private const val USERNAME = "username"
        private const val EMAIL = "email"
        private const val BIO = "bio"
        private const val WORK = "work"
        private const val SCHOOL = "school"
        private const val CONTACT = "contact"
        private const val BIRTHDAY = "birthday"
        private const val PHONE = "phone"

        /*CREATE TABLE students ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_number TEXT......);*/
        private const val CREATE_TABLE_USERS = (
            "CREATE TABLE '$TABLE_USERS' (" +
                "'$KEY_ID' INTEGER PRIMARY KEY," +
                "'$FULL_NAME' TEXT NOT NULL," +
                "'$USERNAME' TEXT NOT NULL UNIQUE," +
                "'$EMAIL' TEXT NOT NULL UNIQUE," +
                "'$BIO' TEXT," +
                "'$WORK' TEXT," +
                "'$SCHOOL' TEXT," +
                "'$CONTACT' TEXT," +
                "'$BIRTHDAY' TEXT," +
                "'$PHONE' TEXT" +
            ");"
        )
    }

    val allStudentsList: ArrayList<String>
        get() {
            val usersArrayList = ArrayList<String>()
            var name = ""
            val selectQuery = "SELECT  * FROM $TABLE_USERS"
            val db = this.readableDatabase
            val c = db.rawQuery(selectQuery, null)
            if (c.moveToFirst()) {
                do {
                    name = c.getString(c.getColumnIndex(KEY_ID))
                    usersArrayList.add(name)
                } while (c.moveToNext())
            }
            return usersArrayList
        }

    fun addUser(user: User): Long {
        val db = this.writableDatabase
        // Creating content values
        val values = ContentValues()
        values.put(KEY_ID, user.userID)
        values.put(FULL_NAME, user.fullName)
        values.put(USERNAME, user.userName)
        values.put(EMAIL, user.email.toString())
        values.put(BIO, user.bio)
        values.put(WORK, user.work)
        values.put(SCHOOL, user.school)
        values.put(CONTACT, user.contact)
        values.put(BIRTHDAY, user.birthday.toString())
        values.put(PHONE, user.phone.toString())

        // Insert row in users table
        return db.insert(TABLE_USERS, null, values)
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_USERS)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS '$TABLE_USERS'")
        onCreate(db)
    }
}