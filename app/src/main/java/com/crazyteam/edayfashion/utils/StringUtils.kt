package com.crazyteam.edayfashion.utils

import java.text.DecimalFormat

fun String?.isNotNullOrEmpty() = this?.isNotBlank() ?: false

fun getCurrencyFormatter() = DecimalFormat("#,### đ")