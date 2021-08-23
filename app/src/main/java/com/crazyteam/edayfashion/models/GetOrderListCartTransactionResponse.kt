package com.crazyteam.edayfashion.models

data class GetOrderListCartTransactionResponse(
    val message: String?,
    val data: MutableList<AddCartData> = mutableListOf()
)