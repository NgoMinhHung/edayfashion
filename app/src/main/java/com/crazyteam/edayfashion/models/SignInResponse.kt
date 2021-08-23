package com.crazyteam.edayfashion.models

data class SignInResponse(
    val code: Int?,
    val data: SignInData?,
    val message: String
)