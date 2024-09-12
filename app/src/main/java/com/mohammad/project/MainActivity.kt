package com.mohammad.project

import android.Manifest
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.mohammad.project.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            try {
                if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==
                    PackageManager.PERMISSION_DENIED){getRequestsPermison()}
            } catch (E: Exception) {
                Toast.makeText(this, E.message, Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun getRequestsPermison() {
        try {
            ActivityCompat.shouldShowRequestPermissionRationale(
                this,Manifest.permission.CAMERA)
            AlertDialog.Builder(this).setTitle("permison")
                .setMessage("get permison camera")
                .setPositiveButton("acsess"){_,_ ->requestCameraPermison()}
                .setNegativeButton("Deny"){dialog,_ ->dialog.dismiss()}
        }catch (E:Exception){Toast.makeText(this,E.message,Toast.LENGTH_LONG).show()
    }
}

    private fun requestCameraPermison() {
        try {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),200)
        }catch (E:Exception){Toast.makeText(this,E.message,Toast.LENGTH_LONG).show()}

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        try {
            if (requestCode==200){
                if (grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"acsess permison",Toast.LENGTH_LONG).show()
                }
                else
                    Toast.makeText(this,"not acsess permison",Toast.LENGTH_LONG).show()
            }
            else{
                super.onRequestPermissionsResult(requestCode, permissions, grantResults)}
        }catch (E:Exception){Toast.makeText(this,E.message,Toast.LENGTH_LONG).show()}

    }


}






