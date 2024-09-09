package com.mohammad.project
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohammad.project.databinding.ActivityLogInBinding
import com.mohammad.project.pakagel_log_in.DataUser


class LogIn : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private var username =""
    private var pass = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datauser = getSharedPreferences("all_data", MODE_PRIVATE)

        binding.btmLoginpage.setOnClickListener {

            username = binding.username.text.toString().trim()
            pass = binding.pass.text.toString().trim()
            binding.username.text.clear()
            binding.pass.text.clear()
            DataUser().saveData(datauser, username, pass)
            DataUser().setObjectData(datauser)
            val go_file_maniger = Intent(this, FileManiger::class.java)
            startActivity(go_file_maniger)
        }
        binding.loguppage.setOnClickListener{
            val activitylogup = Intent(this,LogUp::class.java)
            startActivity(activitylogup)
        }
   }
}