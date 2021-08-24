package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class AddCartData(
    val id: Int,
    val product: Transaction,
    val proId: Int,
    val amount: Int,
    val price: Float,
    val addDay: Date?,
    val status: String
)