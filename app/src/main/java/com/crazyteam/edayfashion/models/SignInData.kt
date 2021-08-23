package com.crazyteam.edayfashion.models

data class SignInData(
    val token: String?,
    val user: User?,
    val role: String?
)