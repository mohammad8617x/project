package com.mohammad.project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mohammad.project.databinding.ActivityLogInBinding

class SignUpActivityV2 : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private lateinit var sharedPreferencesManager: SharedPreferencesManager
    private var username = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the SharedPreferencesManager
        sharedPreferencesManager = SharedPreferencesManager(this)

        binding.btmLoginpage.setOnClickListener {
            username = binding.username.text.toString().trim()
            password = binding.pass.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Save username and password to SharedPreferences
                sharedPreferencesManager.saveData(username, password)

                // Clear input fields
                binding.username.text.clear()
                binding.pass.text.clear()

                // Navigate to File Manager activity
                val intent = Intent(this, FileManagerActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_LONG).show()
            }
        }

        binding.loguppage.setOnClickListener {
            val intent = Intent(this, LoginActivityV2::class.java)
            startActivity(intent)
        }
    }
}
