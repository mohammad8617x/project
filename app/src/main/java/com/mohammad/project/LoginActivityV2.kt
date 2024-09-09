package com.mohammad.project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mohammad.project.databinding.ActivityLogUpBinding

class LoginActivityV2 : AppCompatActivity() {

    private lateinit var binding: ActivityLogUpBinding
    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the SharedPreferencesManager
        sharedPreferencesManager = SharedPreferencesManager(this)

        binding.btmlogup.setOnClickListener {
            val savedUsername = sharedPreferencesManager.getUsername()
            val savedPassword = sharedPreferencesManager.getPassword()

            if (savedUsername == null || savedPassword == null) {
                Toast.makeText(this, "Please log in before signing up", Toast.LENGTH_LONG).show()
            } else {
                val inputUsername = binding.edtusername.text.toString()
                val inputPassword = binding.password.text.toString()

                if (savedUsername == inputUsername && savedPassword == inputPassword) {
                    // Clear input fields
                    binding.edtusername.text.clear()
                    binding.password.text.clear()

                    // Navigate to File Manager activity
                    val intent = Intent(this, FileManagerActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.login.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }
    }
}
