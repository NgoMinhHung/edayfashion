package com.crazyteam.edayfashion.utils

object Constants {
    object PreferenceKeys {
        const val AuthPreferenceName = "AUTH_PREFS"
        const val Token = "token"
        const val UserId = "user_id"
    }

    object IntentKeys {
        const val UserName = "name"
        const val UserGender = "gender"
        const val UserImageUrl = "image_url"
        const val UserAddress = "address"
        const val UserPhoneNumber = "phone"

        const val UpdateUserFlag = 1011
        const val ViewTransactionsFlag = 1001
    }
}