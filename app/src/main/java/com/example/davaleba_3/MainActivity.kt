package com.example.davaleba_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var firstOper = 0.0
    private var operation = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = this.findViewById(R.id.textView)
    }


    fun numberClick(clickView: View) {
        if (clickView is Button) {
            var result = resultTextView.text.toString()
            val buttonNumber = clickView.text.toString()

//            აქ რაღაც ლოგიკა არ მაქ მთლად სწორი :დ
//            ანუ ეს ათწილადის წერტილი მინდა რო მხოლოდ ერთხელ დავწერო მარა ვერ ვშვები,
//            პირველი რო არ დაიწყოს ამ წერტილით ეგეც არ გამოდის

            if (result == "0" || result == ".") {
                result = ""
            }
            val res = result + buttonNumber
            resultTextView.text = res
        }

    }

    fun operationClick(clickView: View) {
        if (clickView is Button) {

            val firstNumber = resultTextView.text.toString()
            if (firstNumber.isNotEmpty()) {
                firstOper = firstNumber.toDouble()
            }
            this.operation = clickView.text.toString()
            resultTextView.text = ""

            when (operation) {
                "+/-" -> resultTextView.text = (-firstOper).toString()
            }


        }

    }

    fun equalClick(clickView: View) {
        if (clickView is Button) {
            val secNumber = resultTextView.text.toString()
            var sn = 0.0
            if (secNumber.isNotEmpty()) {
                sn = secNumber.toDouble()
            }
            when (operation) {
                "+" -> resultTextView.text = (firstOper + sn).toString()
                "-" -> resultTextView.text = (firstOper - sn).toString()
                "*" -> resultTextView.text = (firstOper * sn).toString()
                "/" -> resultTextView.text = (firstOper / sn).toString()
                "%" -> resultTextView.text = (firstOper * sn / 100).toString()
//                ჯერ უნდა დააჭირო ფესვს და მერე დაწერილი რიცხვიდან ამოიღებს
                "√" -> resultTextView.text = (sqrt(sn)).toString()

            }
        }
    }

    fun clearClick(clickView: View) {
        if (clickView is Button) {
            resultTextView.text = "0"
            firstOper = 0.0
            operation = ""

        }
    }


}