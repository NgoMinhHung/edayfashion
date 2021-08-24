package com.crazyteam.edayfashion.models

import java.util.Date

data class DataListCart(
    val total: Int,
    val listOrder: MutableList<AddCartData> = mutableListOf()

)