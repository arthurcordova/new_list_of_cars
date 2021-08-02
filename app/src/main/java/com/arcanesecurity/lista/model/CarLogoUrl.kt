package com.arcanesecurity.lista.model

import androidx.annotation.DrawableRes
import com.arcanesecurity.lista.R
import java.io.Serializable

enum class CarLogoUrl(val url: String, @DrawableRes val placeholder: Int) : Serializable {

    FIAT(
        "https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/fiat.jpg",
        R.drawable.ic_favorite
    ),
    VW(
        "https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/volkswagen.jpg",
        R.drawable.ic_baseline_directions_car_24
    ),
    CHEVROLET(
        "https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/chevrolet.jpg",
        R.drawable.ic_launcher_foreground
    ),
    JEEP(
        "https://raw.githubusercontent.com/filippofilip95/car-logos-dataset/master/logos/original/jeep.jpg",
        R.drawable.ic_launcher_foreground
    )
}