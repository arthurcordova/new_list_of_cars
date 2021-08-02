package com.arcanesecurity.lista.adapter

import com.arcanesecurity.lista.model.Car

interface ClickableItem {

    fun onDelete(car: Car)
    fun onEdit(car: Car)

}