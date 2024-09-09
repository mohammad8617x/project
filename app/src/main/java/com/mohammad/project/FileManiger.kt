package com.mohammad.project

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mohammad.project.databinding.ActivityFileManigerBinding

class FileManiger : AppCompatActivity() {
    private lateinit var binding:ActivityFileManigerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFileManigerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        }
    }
