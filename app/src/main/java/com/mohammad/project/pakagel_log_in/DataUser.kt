package com.mohammad.project.pakagel_log_in


import android.content.SharedPreferences

class DataUser {
    private lateinit var sheard:SharedPreferences
    fun saveData(object_sheard:SharedPreferences,username:String,password:String){
        val savedata = object_sheard.edit()
        savedata.putString("username",username)
        savedata.putString("password",password)
        savedata.apply()
    }
    fun setObjectData(objectData:SharedPreferences) {
        sheard = objectData
    }
    fun getObjectData():SharedPreferences{
        return this.sheard
    }


}