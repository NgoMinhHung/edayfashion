package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class AddCartData(
    val id: Int,
    val name: String?,
    @SerializedName("image")
    val imageUrl: String?,
    val user_id: Int,
    val proId: Int,
    val amount: Int,
    val price: Float,
    val createDay: Date?,
    val updateDay: Date?,
    val buyDay: Date?,
    val state: Int
)