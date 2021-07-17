package com.example.pucitcgpacalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import android.widget.Toast

class SGPAActivity2 : AppCompatActivity() {

//    var arrMarks = arrayOf(0,0,0,0,0,0,0,0)
    var arrGPA = arrayOf(floatArrayOf(0F, 0F), floatArrayOf(0F, 0F), floatArrayOf(0F, 0F), floatArrayOf(0F, 0F),
        floatArrayOf(0F, 0F), floatArrayOf(0F, 0F), floatArrayOf(0F, 0F), floatArrayOf(0F, 0F))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sgpaactivity2)
//Number PickerM1 and creditH NP 1
        val numberPicker1 = findViewById<NumberPicker>(R.id.numberPicker_m1)
        if (numberPicker1 != null) {
            numberPicker1.minValue = 0
            numberPicker1.maxValue = 100
            numberPicker1.wrapSelectorWheel = true
            numberPicker1.setOnValueChangedListener { _, oldVal, newVal ->
//                val text = "Marks are set to $newVal"
                subjectGpaSetter(0,newVal)
//                Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        }

        val ch1 = findViewById<NumberPicker>(R.id.numberPicker_c1)
        if (ch1 != null) {
            ch1.minValue = 0
            ch1.maxValue = 6
            ch1.wrapSelectorWheel = true
            ch1.setOnValueChangedListener { _, oldVal, newVal ->
                arrGPA[0][1] = newVal.toFloat()
  //              val text = "Credit Hours are set to $newVal"
    //            Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        //Number PickerM2 and creditH NP 2
        val numberPicker2 = findViewById<NumberPicker>(R.id.numberPicker_m2)
        if (numberPicker2 != null) {
            numberPicker2.minValue = 0
            numberPicker2.maxValue = 100
            numberPicker2.wrapSelectorWheel = true
            numberPicker2.setOnValueChangedListener { _, oldVal, newVal ->
      //          val text = "Marks are set to $newVal"
                subjectGpaSetter(1,newVal)
       //         Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        }

        val ch2 = findViewById<NumberPicker>(R.id.numberPicker_c2)
        if (ch2 != null) {
            ch2.minValue = 0
            ch2.maxValue = 6
            ch2.wrapSelectorWheel = true
            ch2.setOnValueChangedListener { _, oldVal, newVal ->
                arrGPA[1][1] = newVal.toFloat()
       //         val text = "Credit Hours are set to $newVal"
        //        Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }

        //Number PickerM3 and creditH NP 3
        val numberPicker3 = findViewById<NumberPicker>(R.id.numberPicker_m3)
        if (numberPicker3 != null) {
            numberPicker3.minValue = 0
            numberPicker3.maxValue = 100
            numberPicker3.wrapSelectorWheel = true
            numberPicker3.setOnValueChangedListener { _, oldVal, newVal ->
         //       val text = "Marks are set to $newVal"
                subjectGpaSetter(2,newVal)
          //      Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        }

        val ch3 = findViewById<NumberPicker>(R.id.numberPicker_c3)
        if (ch3 != null) {
            ch3.minValue = 0
            ch3.maxValue = 6
            ch3.wrapSelectorWheel = true
            ch3.setOnValueChangedListener { _, oldVal, newVal ->
                arrGPA[2][1] = newVal.toFloat()
            //    val text = "Credit Hours are set to $newVal"
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
                //Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        //Number PickerM4 and creditH NP 4
        val numberPicker4 = findViewById<NumberPicker>(R.id.numberPicker_m4)
        if (numberPicker4 != null) {
            numberPicker4.minValue = 0
            numberPicker4.maxValue = 100
            numberPicker4.wrapSelectorWheel = true
            numberPicker4.setOnValueChangedListener { _, oldVal, newVal ->
          //      val text = "Marks are set to $newVal"
                //val text = "Changed from $oldVal to $newVal"
                subjectGpaSetter(3,newVal)
            //    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        }

        val ch4 = findViewById<NumberPicker>(R.id.numberPicker_c4)
        if (ch4 != null) {
            ch4.minValue = 0
            ch4.maxValue = 6
            ch4.wrapSelectorWheel = true
            ch4.setOnValueChangedListener { _, oldVal, newVal ->
                arrGPA[3][1] = newVal.toFloat()
         //       val text = "Credit Hours are set to $newVal"
            //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
           //     Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        //Number PickerM5 and creditH NP 5
        val numberPicker5 = findViewById<NumberPicker>(R.id.numberPicker_m5)
        if (numberPicker5 != null) {
            numberPicker5.minValue = 0
            numberPicker5.maxValue = 100
            numberPicker5.wrapSelectorWheel = true
            numberPicker5.setOnValueChangedListener { _, oldVal, newVal ->
                val text = "Marks are set to $newVal"
                //val text = "Changed from $oldVal to $newVal"
                subjectGpaSetter(4,newVal)
               // Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        }

        val ch5 = findViewById<NumberPicker>(R.id.numberPickr_c5)
        if (ch5 != null) {
            ch5.minValue = 0
            ch5.maxValue = 6
            ch5.wrapSelectorWheel = true
            ch5.setOnValueChangedListener { _, oldVal, newVal ->
                arrGPA[4][1] = newVal.toFloat()
         //       val text = "Credit Hours are set to $newVal"
            //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
                //Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        //Number PickerM6 and creditH NP 6
        val numberPicker6 = findViewById<NumberPicker>(R.id.numberPicker_m6)
        if (numberPicker6 != null) {
            numberPicker6.minValue = 0
            numberPicker6.maxValue = 100
            numberPicker6.wrapSelectorWheel = true
            numberPicker6.setOnValueChangedListener { _, oldVal, newVal ->
           //     val text = "Marks are set to $newVal"
                //val text = "Changed from $oldVal to $newVal"
                subjectGpaSetter(5,newVal)
             //   Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        }

        val ch6 = findViewById<NumberPicker>(R.id.numberPickr_c6)
        if (ch6 != null) {
            ch6.minValue = 0
            ch6.maxValue = 6
            ch6.wrapSelectorWheel = true
            ch6.setOnValueChangedListener { _, oldVal, newVal ->
                arrGPA[5][1] = newVal.toFloat()
               // val text = "Credit Hours are set to $newVal"
            //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
               // Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }

        //Number PickerM7 and creditH NP 7
        val numberPicker7 = findViewById<NumberPicker>(R.id.numberPicker_m7)
        if (numberPicker7 != null) {
            numberPicker7.minValue = 0
            numberPicker7.maxValue = 100
            numberPicker7.wrapSelectorWheel = true
            numberPicker7.setOnValueChangedListener { _, oldVal, newVal ->
                val text = "Marks are set to $newVal"
                //val text = "Changed from $oldVal to $newVal"
                subjectGpaSetter(6,newVal)
               // Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        }

        val ch7 = findViewById<NumberPicker>(R.id.numberPickr_c7)
        if (ch7 != null) {
            ch7.minValue = 0
            ch7.maxValue = 6
            ch7.wrapSelectorWheel = true
            ch7.setOnValueChangedListener { _, oldVal, newVal ->
                arrGPA[6][1] = newVal.toFloat()
           //     val text = "Credit Hours are set to $newVal"
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
            //    Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        //Number PickerM8 and creditH NP 8
        val numberPicker8 = findViewById<NumberPicker>(R.id.numberPicker_m8)
        if (numberPicker8 != null) {
            numberPicker8.minValue = 0
            numberPicker8.maxValue = 100
            numberPicker8.wrapSelectorWheel = true
            numberPicker8.setOnValueChangedListener { _, oldVal, newVal ->
             //   val text = "Marks are set to $newVal"
                //val text = "Changed from $oldVal to $newVal"
                subjectGpaSetter(7,newVal)
               // Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }
        }

        val ch8 = findViewById<NumberPicker>(R.id.numberPickr_c8)
        if (ch8 != null) {
            ch8.minValue = 0
            ch8.maxValue = 6
            ch8.wrapSelectorWheel = true
            ch8.setOnValueChangedListener { _, oldVal, newVal ->
                arrGPA[7][1] = newVal.toFloat()
               // val text = "Credit Hours are set to $newVal"
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
            //    Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun subjectGpaSetter(i: Int,marks: Int){
        if ((marks>=85) and (marks<=100))
        {
                arrGPA[i][0] = 4F
        }
        if ((marks>=80) and (marks<85))
        {
            arrGPA[i][0] = 3.7F
        }
        if ((marks>=75) and (marks<80))
        {
            arrGPA[i][0] = 3.3F
        }
        if ((marks>=70) and (marks<75))
        {
            arrGPA[i][0] = 3.0F
        }
        if ((marks>=65) and (marks<70))
        {
            arrGPA[i][0] = 2.7F
        }
        if ((marks>=61) and (marks<65))
        {
            arrGPA[i][0] = 2.3F
        }
        if ((marks>=58) and (marks<61))
        {
            arrGPA[i][0] = 2F
        }
        if ((marks>=55) and (marks<58))
        {
            arrGPA[i][0] = 1.7F
        }
        if ((marks>=50) and (marks<55))
        {
            arrGPA[i][0] = 1.0F
        }
        if ((marks>=0) and (marks<50))
        {
            arrGPA[i][0] = 0F
        }
    }

    fun onResult(view: View)
    {
        val result = calSGPA()
        val intent = Intent(applicationContext,result_sgpa::class.java)
        intent.putExtra("res",result)
        startActivity(intent)

    }

    fun calSGPA() : Float{
        //Toast.makeText(this, "Button Works!", Toast.LENGTH_LONG).show()
        var combGPA = 0f
        var combCh = 0f
        var ii = 0
        arrGPA.forEach {
            combGPA += arrGPA[ii][0]*arrGPA[ii][1]
            combCh += arrGPA[ii][1]
            ii++
            }
        return combGPA/combCh
        }
}
