package com.mohammad.project

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.mohammad.project.databinding.ActivityMainBinding
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            try {
                if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                    PackageManager.PERMISSION_DENIED){getRequestsPermison() }
                else{ Toast.makeText(this,"accessed",Toast.LENGTH_LONG).show()}
            } catch (e: Exception){
                Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
            }



    }

    private fun getRequestsPermison() {
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
            AlertDialog.Builder(this).setTitle("permison")
                .setMessage("get permison write")
                .setPositiveButton("access"){_,_ ->requestCameraPermison()}
                .setNegativeButton("deny"){dialog,_ ->dialog.dismiss()}
                .create().show()
}

    private fun requestCameraPermison() {
        val data_permison = Array<String>(1){Manifest.permission.WRITE_EXTERNAL_STORAGE}
        ActivityCompat.requestPermissions(this, data_permison,2000)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
            if (requestCode.equals(2000)){
                if (grantResults.size>0)
                    if (grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    Log.i("log_permison","access")
                else
                    Log.i("log_permison",grantResults[0].toString())
            }
            else{
                Log.i("log_permison","requests code !=2000")
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)}
        }

    }









