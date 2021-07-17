package com.example.pucitcgpacalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cgpaactivity3.*

class CGPAActivity3 : AppCompatActivity() {

    var arrSGPA = arrayOf(floatArrayOf(0F, 0F), floatArrayOf(0F, 0F), floatArrayOf(0F, 0F), floatArrayOf(0F, 0F),
        floatArrayOf(0F, 0F), floatArrayOf(0F, 0F), floatArrayOf(0F, 0F), floatArrayOf(0F, 0F))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cgpaactivity3)

        //Number PickerM1 and creditH NP 1


            val ch1 = findViewById<NumberPicker>(R.id.numberPickr_c1)
            if (ch1 != null) {
                ch1.minValue = 0
                ch1.maxValue = 32
                ch1.wrapSelectorWheel = true
                ch1.setOnValueChangedListener { _, oldVal, newVal ->
                    arrSGPA[0][1] = newVal.toFloat()
  //                  val text = "Credit Hours are set to $newVal"
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
//                    Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
                }
            }


        //Number PickerM2 and creditH NP 2


        val ch2 = findViewById<NumberPicker>(R.id.numberPickr_c2)
        if (ch2 != null) {
            ch2.minValue = 0
            ch2.maxValue = 32
            ch2.wrapSelectorWheel = true
            ch2.setOnValueChangedListener { _, oldVal, newVal ->
                arrSGPA[1][1] = newVal.toFloat()
    //            val text = "Credit Hours are set to $newVal"
            //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
      //          Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        val ch3 = findViewById<NumberPicker>(R.id.numberPickr_c3)
        if (ch3 != null) {
            ch3.minValue = 0
            ch3.maxValue = 32
            ch3.wrapSelectorWheel = true
            ch3.setOnValueChangedListener { _, oldVal, newVal ->
                arrSGPA[2][1] = newVal.toFloat()
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
        //        val text = "Credit Hours are set to $newVal"
          //      Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        //Number PickerM4 and creditH NP 4


        val ch4 = findViewById<NumberPicker>(R.id.numberPickr_c4)
        if (ch4 != null) {
            ch4.minValue = 0
            ch4.maxValue = 32
            ch4.wrapSelectorWheel = true
            ch4.setOnValueChangedListener { _, oldVal, newVal ->
                arrSGPA[3][1] = newVal.toFloat()
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
            //    val text = "Credit Hours are set to $newVal"
              //  Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        //Number PickerM5 and creditH NP 5

        val ch5 = findViewById<NumberPicker>(R.id.numberPickr_c5)
        if (ch5 != null) {
            ch5.minValue = 0
            ch5.maxValue = 32
            ch5.wrapSelectorWheel = true
            ch5.setOnValueChangedListener { _, oldVal, newVal ->
                arrSGPA[4][1] = newVal.toFloat()
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
              //  val text = "Credit Hours are set to $newVal"
                //Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        //Number PickerM6 and creditH NP 6



        val ch6 = findViewById<NumberPicker>(R.id.numberPickr_c6)
        if (ch6 != null) {
            ch6.minValue = 0
            ch6.maxValue = 32
            ch6.wrapSelectorWheel = true
            ch6.setOnValueChangedListener { _, oldVal, newVal ->
                arrSGPA[5][1] = newVal.toFloat()
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
                //val text = "Credit Hours are set to $newVal"
                //Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }

        //Number PickerM7 and creditH NP 7

        val ch7 = findViewById<NumberPicker>(R.id.numberPickr_c7)
        if (ch7 != null) {
            ch7.minValue = 0
            ch7.maxValue = 32
            ch7.wrapSelectorWheel = true
            ch7.setOnValueChangedListener { _, oldVal, newVal ->
                arrSGPA[6][1] = newVal.toFloat()
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
                //val text = "Credit Hours are set to $newVal"
                //Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }


        //Number PickerM8 and creditH NP 8

        val ch8 = findViewById<NumberPicker>(R.id.numberPickr_c8)
        if (ch8 != null) {
            ch8.minValue = 0
            ch8.maxValue = 32
            ch8.wrapSelectorWheel = true
            ch8.setOnValueChangedListener { _, oldVal, newVal ->
                arrSGPA[7][1] = newVal.toFloat()
                //val text = "value changed from $oldVal to ${arrGPA[0][1]}"
                //val text = "Credit Hours are set to $newVal"
            //    Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setSGPAarray()
    {
        //edit text 1
        if (editTextNumberDecimal.text.toString()=="")
        {
           arrSGPA[0][0] = 0F
        }
        else
        {
            arrSGPA[0][0] = editTextNumberDecimal.text.toString().toFloat()
        }

        //edit text 2
        if (editTextNumberDecimal2.text.toString()=="")
        {
            arrSGPA[1][0] = 0F
        }
        else
        {
            arrSGPA[1][0] = editTextNumberDecimal2.text.toString().toFloat()
        }

        //edit text 3
        if (editTextNumberDecimal3.text.toString()=="")
        {
            arrSGPA[2][0] = 0F
        }
        else
        {
            arrSGPA[2][0] = editTextNumberDecimal3.text.toString().toFloat()
        }

        //edit text 4
        if (editTextNumberDecimal4.text.toString()=="")
        {
            arrSGPA[3][0] = 0F
        }
        else
        {
            arrSGPA[3][0] = editTextNumberDecimal4.text.toString().toFloat()
        }

        //edit text 5
        if (editTextNumberDecimal5.text.toString()=="")
        {
            arrSGPA[4][0] = 0F
        }
        else
        {
            arrSGPA[4][0] = editTextNumberDecimal5.text.toString().toFloat()
        }

        //edit text 6
        if (editTextNumberDecimal6.text.toString()=="")
        {
            arrSGPA[5][0] = 0F
        }
        else
        {
            arrSGPA[5][0] = editTextNumberDecimal6.text.toString().toFloat()
        }

        //edit text 7
        if (editTextNumberDecimal7.text.toString()=="")
        {
            arrSGPA[6][0] = 0F
        }
        else
        {
            arrSGPA[6][0] = editTextNumberDecimal7.text.toString().toFloat()
        }

        //edit text 8
        if (editTextNumberDecimal8.text.toString()=="")
        {
            arrSGPA[7][0] = 0F
        }
        else
        {
            arrSGPA[7][0] = editTextNumberDecimal8.text.toString().toFloat()
        }



    }

    fun onResult(view: View)
    {
        setSGPAarray()
        val result = calSGPA()
        val intent = Intent(applicationContext,result_cgpa::class.java)
        intent.putExtra("cres",result)
        startActivity(intent)

    }

    fun calSGPA() : Float{
        //Toast.makeText(this, "Button Works!", Toast.LENGTH_LONG).show()
        var combGPA = 0f
        var combCh = 0f
        var ii = 0
        arrSGPA.forEach {
            combGPA += arrSGPA[ii][0]*arrSGPA[ii][1]
            combCh += arrSGPA[ii][1]
            ii++
        }
        return combGPA/combCh
        }
    }

