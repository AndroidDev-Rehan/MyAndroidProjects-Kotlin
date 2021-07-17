package com.example.pucitcgpacalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onSGPA(view: View) {
        //Toast.makeText(this, "Button Works!", Toast.LENGTH_LONG).show()
        val intent: Intent = Intent(applicationContext,SGPAActivity2::class.java)
        startActivity(intent)
    }

    fun onCGPA(view: View) {
        //Toast.makeText(this, "Button Works!", Toast.LENGTH_LONG).show()
        val intent: Intent = Intent(applicationContext,CGPAActivity3::class.java)
        startActivity(intent)
    }


}