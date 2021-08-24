package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName

data class UpdateUserParams(
    @SerializedName("username")
    val username: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("addr")
    val addr: String,
    @SerializedName("sex")
    val sex: Int,
    @SerializedName("birthDay")
    val birthDay : String?,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String
)