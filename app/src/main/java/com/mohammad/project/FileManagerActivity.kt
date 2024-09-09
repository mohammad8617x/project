package com.mohammad.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohammad.project.databinding.ActivityFileManigerBinding

class FileManagerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFileManigerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFileManigerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        }
    }
