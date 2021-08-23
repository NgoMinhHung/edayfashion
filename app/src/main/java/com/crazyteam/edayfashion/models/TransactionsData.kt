package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName

data class TransactionsData(
//    @SerializedName("data")
    val transaction_item: MutableList<Transaction> = mutableListOf()
)