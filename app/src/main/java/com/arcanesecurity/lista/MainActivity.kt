package com.arcanesecurity.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arcanesecurity.lista.adapter.AdapterRecyclerView
import com.arcanesecurity.lista.model.Car
import com.arcanesecurity.lista.model.CarLogoUrl

class MainActivity : AppCompatActivity() {

    private lateinit var carRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listOfCars = listOf(
            Car("Chevrolet", "Celta", 2012, CarLogoUrl.CHEVROLET),
            Car("Chevrolet", "S10", 2020, CarLogoUrl.CHEVROLET),
            Car("Fiat", "Palio", 2018, CarLogoUrl.FIAT),
            Car("Fiat", "Strada", 2010, CarLogoUrl.FIAT),
            Car("VW", "Gol", 2010, CarLogoUrl.VW),
            Car("VM", "Amarok", 2010, CarLogoUrl.VW),
        )

        carRecyclerView = findViewById(R.id.carsRecyclerView)
        carRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        carRecyclerView.adapter = AdapterRecyclerView(listOfCars)

    }
}