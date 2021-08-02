package com.arcanesecurity.lista.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arcanesecurity.lista.R
import com.arcanesecurity.lista.model.Car
import com.bumptech.glide.Glide

class AdapterRecyclerView(
    val listOfCars: MutableList<Car>,
    val onClick: (Car) -> Unit
) : RecyclerView.Adapter<ItemCarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ItemCarViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ItemCarViewHolder, position: Int) {
        listOfCars[position].apply {
            viewHolder.bind(this)
            viewHolder.itemView.setOnClickListener {
                onClick(this)
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfCars.size
    }

    fun removeAt(car: Car) {
        listOfCars.remove(car)
        notifyDataSetChanged()
    }

    fun add(car: Car) {
        listOfCars.add(car)
        notifyDataSetChanged()
    }

}

class ItemCarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(car: Car) {
        itemView.findViewById<TextView>(R.id.textViewMarca).apply {
            text = car.marca
        }
        itemView.findViewById<TextView>(R.id.textViewModelo).apply {
            text = car.modelo
        }
        itemView.findViewById<TextView>(R.id.textViewAno).apply {
            text = car.ano.toString()
        }
        itemView.findViewById<ImageView>(R.id.marcaLogoImageView).apply {
            Glide.with(context)
                .load(car.logo.url)
                .placeholder(car.logo.placeholder)
                .into(this)
        }
    }

}