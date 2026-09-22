package com.example.zadanie1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val waga = findViewById<EditText>(R.id.waga)
        val wzrost = findViewById<EditText>(R.id.wzrost)
        val oblicz = findViewById<Button>(R.id.oblicz)
        val wynik = findViewById<TextView>(R.id.wynik)

        oblicz.setOnClickListener {

            val wagaTekst = waga.text.toString()
            val wzrostTekst = wzrost.text.toString()

            if (wagaTekst.isEmpty() || wzrostTekst.isEmpty()) {
                Toast.makeText(
                    this,
                    "Podaj wagę i wzrost!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val kg = wagaTekst.toDouble()
            val cm = wzrostTekst.toDouble()

            if (kg <= 0 || cm <= 0) {
                Toast.makeText(
                    this,
                    "Waga i wzrost muszą być większe od 0!",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val metry = cm / 100
            val bmi = kg / (metry * metry)

            val kategoria = when {
                bmi < 18.5 -> "Niedowaga"
                bmi < 25 -> "Prawidłowa masa ciała"
                bmi < 30 -> "Nadwaga"
                else -> "Otyłość"
            }

            wynik.text = String.format(
                "BMI: %.2f\n%s",
                bmi,
                kategoria
            )
        }
    }
}