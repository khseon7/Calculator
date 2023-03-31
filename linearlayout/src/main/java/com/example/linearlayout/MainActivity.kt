package com.example.linearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var num1 : String
        lateinit var num2 : String
        var result : Int?=null
        var result_double : Double?=null
        var edit1 = findViewById<EditText>(R.id.Edit1)
        var edit2 = findViewById<EditText>(R.id.Edit2)
        val btnAdd = findViewById<Button>(R.id.BtnAdd)
        val btnSub = findViewById<Button>(R.id.BtnSub)
        val btnMul = findViewById<Button>(R.id.BtnMul)
        val btnDiv = findViewById<Button>(R.id.BtnDiv)
        var textResult = findViewById<TextView>(R.id.TextResult)
        btnAdd.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = result.toString()
        }
        btnSub.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = result.toString()
        }
        btnMul.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = result.toString()
        }
        btnDiv.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            result_double = num1.toDouble() / num2.toDouble()
            textResult.text = result_double.toString()
        }
    }
}