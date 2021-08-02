package com.arcanesecurity.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.arcanesecurity.lista.model.Car
import com.bumptech.glide.Glide

class DetailCarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_car)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val car = intent.getSerializableExtra("parametro_carro") as? Car

        car?.let { myCar ->

            supportActionBar?.title = "${myCar.marca} - ${myCar.modelo}"
            findViewById<ImageView>(R.id.logoImageView).apply {
                Glide.with(context)
                    .load(myCar.logo.url)
                    .into(this)
            }
            findViewById<TextView>(R.id.marcaTextView).apply {
                text = myCar.marca
            }
            findViewById<TextView>(R.id.modeloTextView).apply {
                text = myCar.modelo
            }
            findViewById<TextView>(R.id.anoTextView).apply {
                text = myCar.ano.toString()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}