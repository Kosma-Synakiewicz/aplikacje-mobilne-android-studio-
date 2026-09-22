package com.example.zadanie2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val dlugoscHasla = findViewById<EditText>(R.id.dlugoscHasla)

        val maleLitery = findViewById<CheckBox>(R.id.maleLitery)
        val wielkieLitery = findViewById<CheckBox>(R.id.wielkieLitery)
        val cyfry = findViewById<CheckBox>(R.id.cyfry)
        val znakiSpecjalne = findViewById<CheckBox>(R.id.znakiSpecjalne)

        val generuj = findViewById<Button>(R.id.generuj)
        val wynik = findViewById<EditText>(R.id.wynik)

        generuj.setOnClickListener {

            val dlugosc = dlugoscHasla.text.toString().toIntOrNull()

            if (dlugosc == null || dlugosc < 4) {

                Toast.makeText(
                    this,
                    "Podaj długość minimum 4",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            var znaki = ""

            if (maleLitery.isChecked) {
                znaki += "abcdefghijklmnopqrstuvwxyz"
            }

            if (wielkieLitery.isChecked) {
                znaki += "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            }

            if (cyfry.isChecked) {
                znaki += "0123456789"
            }

            if (znakiSpecjalne.isChecked) {
                znaki += "!@#$%^&*()_+-="
            }

            if (znaki.isEmpty()) {

                Toast.makeText(
                    this,
                    "Wybierz przynajmniej jeden rodzaj znaków",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            var haslo = ""

            repeat(dlugosc) {

                val indeks = Random.nextInt(znaki.length)

                haslo += znaki[indeks]
            }

            wynik.setText(haslo)
        }
    }
}