package com.example.zadanie4

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val zadania = ArrayList<String>()
    var wybraneZadanie = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val poleZadania = findViewById<EditText>(R.id.poleZadania)
        val dodaj = findViewById<Button>(R.id.dodaj)
        val usun = findViewById<Button>(R.id.usun)
        val listaZadan = findViewById<ListView>(R.id.listaZadan)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_single_choice,
            zadania
        )

        listaZadan.adapter = adapter
        listaZadan.choiceMode = ListView.CHOICE_MODE_SINGLE

        dodaj.setOnClickListener {

            val zadanie = poleZadania.text.toString()

            if (zadanie.isNotEmpty()) {
                zadania.add(zadanie)

                adapter.notifyDataSetChanged()

                poleZadania.text.clear()
            }
        }

        listaZadan.setOnItemClickListener { _, _, pozycja, _ ->
            wybraneZadanie = pozycja
        }

        usun.setOnClickListener {

            if (wybraneZadanie != -1) {

                zadania.removeAt(wybraneZadanie)

                adapter.notifyDataSetChanged()

                wybraneZadanie = -1
            }
        }
    }
}