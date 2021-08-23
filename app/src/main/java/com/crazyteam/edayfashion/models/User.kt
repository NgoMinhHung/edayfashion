package com.crazyteam.edayfashion.models

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val password: String,
    val sex: Boolean = false,
    val name: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("facebook_url")
    val facebook_url: String?,
    val role: String?,
    val birthDay: String?,
    val addr: String?,
    val startDay: String?,
    val enable: Boolean = false,
    val first_name: String?,
    val last_name: String?,
    val access_token: String?,
    val account_type: String?,
    val phone: String?,
    val avt: String?
)