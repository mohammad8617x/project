package com.mohammad.project

import android.content.Intent
import android.os.Bundle
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

       binding.btmLoginpage.setOnClickListener{
           val username = DataUser().sheard.getString("username","")
           val password = DataUser().sheard.getString("password","")
           if(username==binding.username.text.toString()&&
               password==binding.pass.text.toString()){
               val activity_file_maniger = Intent(this,FileManiger::class.java)
               finish()
               startActivity(activity_file_maniger)
           }else{Toast.makeText(this,"please curect password or username",Toast.LENGTH_LONG)
               .show()}
       }
        binding.loguppage.setOnClickListener{
            val goactivitylogin = Intent(this,LogIn::class.java)
            finish()
            startActivity(goactivitylogin)
        }
    }
}