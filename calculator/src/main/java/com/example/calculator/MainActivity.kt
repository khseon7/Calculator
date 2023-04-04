package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var num1: String
        lateinit var num2: String
        title = "계산기"
        var edit1 = findViewById<EditText>(R.id.edit1)
        var edit2 = findViewById<EditText>(R.id.edit2)
        edit1.setInputType(0)
        edit2.setInputType(0)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btndiv)
        var textResult = findViewById<TextView>(R.id.textResult)
        val btnbs = findViewById<Button>(R.id.partdel)
        val btndel = findViewById<Button>(R.id.del)


        var numButtons = ArrayList<Button>(10)
        var numBtnIDs = arrayOf(
            R.id.BtnNum0,
            R.id.BtnNum1,
            R.id.BtnNum2,
            R.id.BtnNum3,
            R.id.BtnNum4,
            R.id.BtnNum5,
            R.id.BtnNum6,
            R.id.BtnNum7,
            R.id.BtnNum8,
            R.id.BtnNum9
        )

        for(i in 0..numBtnIDs.size-1 step 1){
            numButtons.add(findViewById<Button>(numBtnIDs[i]))
            numButtons[i].setOnClickListener {
                if (edit1.isFocused == true) {
                    num1 = edit1.text.toString() + numButtons[i].getText().toString()
                    edit1.setText(num1)
                } else if (edit2.isFocused == true) {
                    num2 = edit2.text.toString() + numButtons[i].getText().toString()
                    edit2.setText(num2)
                } else {
                    Toast.makeText(applicationContext, "먼저 EditText를 선택하세요", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnbs.setOnClickListener{
            if(edit1.isFocused==true) {
                num1 = edit1.text.toString()
                if (num1!=null) {
                    if (num1.length-1>=0) {
                        num1 = num1.subSequence(0, num1.length - 1) as String
                    } else if( num1.length-1<0){
                        Toast.makeText(applicationContext,"Text가 존재하지 않습니다.",Toast.LENGTH_SHORT).show()
                    }
                    edit1.setText(num1)
                } else{
                    Toast.makeText(applicationContext,"Text가 존재하지 않습니다.",Toast.LENGTH_SHORT).show()
                }
            } else if(edit2.isFocused==true){
                num2=edit2.text.toString()
                if(num2!=null){
                    if (num2.length-1>=0) {
                        num2 = num2.subSequence(0, num2.length - 1) as String
                    } else if( num2.length-1<0){
                        Toast.makeText(applicationContext,"Text가 존재하지 않습니다.",Toast.LENGTH_SHORT).show()
                    }
                    edit2.setText(num2)
                } else{
                    Toast.makeText(applicationContext,"Text가 존재하지 않습니다.",Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(applicationContext,"먼저 EditText를 선택하세요",Toast.LENGTH_SHORT).show()
            }
        }

        btndel.setOnClickListener{
            if(edit1.isFocused==true) {
                edit1.setText(null)
            }else if(edit2.isFocused==true){
                edit2.setText(null)
            } else{
                Toast.makeText(applicationContext,"먼저 EditText를 선택하세요",Toast.LENGTH_SHORT).show()
            }
        }


        btnAdd.setOnTouchListener { view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            var result = Integer.parseInt(num1) + Integer.parseInt(num2)
            textResult.text = result.toString()
            false
        }

        btnSub.setOnTouchListener { view, motionEvent ->
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            var result = Integer.parseInt(num1) - Integer.parseInt(num2)
            textResult.text = result.toString()
            false
        }
        btnMul.setOnTouchListener { view, motionEvent ->
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            var result = Integer.parseInt(num1) * Integer.parseInt(num2)
            textResult.text = result.toString()
            false
        }
        btnDiv.setOnTouchListener { view, motionEvent ->
            var num1 = edit1.text.toString()
            var num2 = edit2.text.toString()
            if(Integer.parseInt(num2)==0){
                Toast.makeText(this@MainActivity,"0으로 못나눠요",Toast.LENGTH_SHORT).show()
            }
            else {
                var result = Integer.parseInt(num1)/Integer.parseInt(num2)
                textResult.text=result.toString()
            }
            false
        }
    }
}