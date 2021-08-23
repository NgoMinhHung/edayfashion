package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName

data class GetTransactionsResponse(
    val message: String?,
    val data: MutableList<Transaction> = mutableListOf()
)