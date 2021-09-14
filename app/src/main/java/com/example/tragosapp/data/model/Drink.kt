package com.example.tragosapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Drink(
   @SerializedName("strDrinkThumb")
    val image: String = "",
    @SerializedName("strDrink")
    val nombre: String = "",
   @SerializedName("strInstructions")
    val descripcion: String = "",
    @SerializedName("strAlcoholic")
    val hasAlcoholic: String = "Non_Alcoholic"
):Parcelable

data class DrinkList(
    @SerializedName("drinks")
    val drinkList: List<Drink>
)