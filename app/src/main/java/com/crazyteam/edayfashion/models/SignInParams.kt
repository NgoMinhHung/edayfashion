package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName

data class SignInParams(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)