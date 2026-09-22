package com.example.zadanie3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var punkty1 = 0
    var punkty2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wynik1 = findViewById<TextView>(R.id.wynik1)
        val wynik2 = findViewById<TextView>(R.id.wynik2)

        val plus1 = findViewById<Button>(R.id.plus1)
        val minus1 = findViewById<Button>(R.id.minus1)

        val plus2 = findViewById<Button>(R.id.plus2)
        val minus2 = findViewById<Button>(R.id.minus2)

        val reset = findViewById<Button>(R.id.reset)

        plus1.setOnClickListener {
            punkty1++
            wynik1.text = punkty1.toString()
        }

        minus1.setOnClickListener {
            if (punkty1 > 0) {
                punkty1--
                wynik1.text = punkty1.toString()
            }
        }

        plus2.setOnClickListener {
            punkty2++
            wynik2.text = punkty2.toString()
        }

        minus2.setOnClickListener {
            if (punkty2 > 0) {
                punkty2--
                wynik2.text = punkty2.toString()
            }
        }

        reset.setOnClickListener {
            punkty1 = 0
            punkty2 = 0

            wynik1.text = "0"
            wynik2.text = "0"
        }
    }
}