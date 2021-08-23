package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName

data class AddCartTransactionParams(
    val proId: Int,
    @SerializedName("amount")
    val amount: Int
)