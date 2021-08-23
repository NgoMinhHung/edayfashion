package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Transaction(
    val id: Int,
    val name: String,
    val amount: Int,
    val size: Int?,
    val price_buy: Float,
    val price_sell: Float,
    val catId: Int,
    val inputDay: Date?,
    @SerializedName("image")
    val imageUrl: String?,
    val media: String?,
    val amount_sell: Float
)