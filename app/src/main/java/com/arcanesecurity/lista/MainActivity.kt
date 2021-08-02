package com.arcanesecurity.lista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arcanesecurity.lista.adapter.AdapterRecyclerView
import com.arcanesecurity.lista.adapter.ClickableItem
import com.arcanesecurity.lista.model.Car
import com.arcanesecurity.lista.model.CarLogoUrl

class MainActivity : AppCompatActivity(), ClickableItem {

    private lateinit var carRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonBottom).apply {
            setOnClickListener { onClickAddNewCar() }
        }

        val listOfCars = mutableListOf(
            Car("Chevrolet", "Celta", 2012, CarLogoUrl.CHEVROLET),
            Car("Chevrolet", "S10", 2020, CarLogoUrl.CHEVROLET),
            Car("Fiat", "Palio", 2018, CarLogoUrl.FIAT),
            Car("Fiat", "Strada", 2010, CarLogoUrl.FIAT),
            Car("VW", "Gol", 2010, CarLogoUrl.VW),
            Car("VM", "Amarok", 2010, CarLogoUrl.VW),
        )

        val adapter = AdapterRecyclerView(listOfCars, this)

        carRecyclerView = findViewById(R.id.carsRecyclerView)
        carRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        carRecyclerView.adapter = adapter
    }


    fun onClickAddNewCar() {
        if (carRecyclerView.adapter is AdapterRecyclerView) {
            (carRecyclerView.adapter as AdapterRecyclerView).add(
                Car(
                    "Jeep",
                    "Renegade",
                    2021,
                    CarLogoUrl.JEEP
                )
            )
        }
    }

    override fun onDelete(car: Car) {
        if (carRecyclerView.adapter is AdapterRecyclerView) {
            (carRecyclerView.adapter as AdapterRecyclerView).removeAt(car)
        }
    }

    override fun onEdit(car: Car) {
        val intentParaDetalhesDoCarro = Intent(this, DetailCarActivity::class.java)
        intentParaDetalhesDoCarro.putExtra("parametro_carro", car)
        startActivity(intentParaDetalhesDoCarro)
    }


}