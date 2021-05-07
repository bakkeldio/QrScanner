package com.example.qrscanner.data

import android.content.Context
import android.content.SharedPreferences


object AppPreferences{

    private const val NAME = "QrApp"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences



    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var language :String
    get() = preferences.getString("language","")!!
    set(value) = preferences.edit {
        it.putString("language",value)
    }

}


