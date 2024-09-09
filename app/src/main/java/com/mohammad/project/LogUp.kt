package com.mohammad.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mohammad.project.databinding.ActivityLogUpBinding
import com.mohammad.project.pakagel_log_in.DataUser

class LogUp : AppCompatActivity() {
    private lateinit var binding: ActivityLogUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btmlogup.setOnClickListener{
           val dataobject = DataUser().getObjectData()
               val username = dataobject.getString("username","not data")
               val password = dataobject.getString("password","not data")
           Log.i("usernamese",username+""+password)
           if(username.equals("not data")||password.equals("not data")){
               Toast.makeText(this,"Please befor log up you login then log up ",
                   Toast.LENGTH_LONG).show()}else{
               if(username.equals(binding.edtusername.text.toString())&&
                   password.equals(binding.password.text.toString())){
                   binding.edtusername.text.clear()
                   binding.password.text.clear()
                   val activity_file_maniger = Intent(this,FileManiger::class.java)
                   startActivity(activity_file_maniger)
               }else{
                   Toast.makeText(this,"please curect password or username",Toast.LENGTH_LONG)
                   .show()}}
    }
        binding.login.setOnClickListener{
            val goactivitylogin = Intent(this,LogIn::class.java)
            startActivity(goactivitylogin)
        }
}}