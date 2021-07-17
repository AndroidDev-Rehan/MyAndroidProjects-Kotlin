package com.example.pucitcgpacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result_sgpa.*

class result_cgpa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_cgpa)
        val intent = getIntent()
        val cgpa = intent.getFloatExtra("cres",0.0F)
        textView1.append(" $cgpa")

    }
}