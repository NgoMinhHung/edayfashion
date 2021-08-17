package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName

class SignUpParams (
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("confirmPassword")
    val confirmPassword: String
)