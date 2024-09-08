package com.mohammad.project.pakagel_log_in


import android.content.SharedPreferences

class DataUser {
    lateinit var sheard:SharedPreferences
    fun saveData(object_sheard:SharedPreferences,username:String,password:String){
        sheard = object_sheard
        val savedata = object_sheard.edit()
        savedata.putString("username",username)
        savedata.putString("password",password)
        savedata.apply()
    }

}