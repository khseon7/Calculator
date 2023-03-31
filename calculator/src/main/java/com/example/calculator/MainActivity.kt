package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "RelativeLayout 계산기"
        var edit1 = findViewById<EditText>(R.id.edit1)
        var edit2 = findViewById<EditText>(R.id.edit2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btndiv)
        var textResult = findViewById<TextView>(R.id.textResult)
        btnAdd.setOnClickListener {
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            var result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = result.toString()
        }
        btnSub.setOnClickListener{
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            var result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = result.toString()
        }
        btnMul.setOnClickListener{
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            var result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = result.toString()
        }
        btnDiv.setOnClickListener{
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            if(Integer.parseInt(num2)==0){
                Toast.makeText(this@MainActivity,"0으로 못나눠요",Toast.LENGTH_SHORT).show()
            }
            else {
                var result = Integer.parseInt(num1)/Integer.parseInt(num2)
                textResult.text=result.toString()
            }
        }
    }
}