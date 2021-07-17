package com.example.pucitcgpacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result_sgpa.*

class result_sgpa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_sgpa)
        val intent = getIntent()
        val sgpa = intent.getFloatExtra("res",0.0F)
        textView1.append(" $sgpa")

    }
}