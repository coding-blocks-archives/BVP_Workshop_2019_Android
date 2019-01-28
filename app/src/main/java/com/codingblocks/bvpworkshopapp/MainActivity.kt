package com.codingblocks.bvpworkshopapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            try {
                val a = etVar1.text.toString().toInt()
                val b = etVar2.text.toString().toInt()
                val c = a + b
                tvResult.text = c.toString()
            } catch (nfe: NumberFormatException) {
                Toast.makeText(
                    this,
                    "Please enter both variables!",
                    Toast.LENGTH_SHORT
                ).show()
            }



        }
    }

}
