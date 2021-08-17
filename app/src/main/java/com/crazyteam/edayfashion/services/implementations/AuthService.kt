package com.crazyteam.edayfashion.services.implementations

import com.crazyteam.edayfashion.models.SignInParams
import com.crazyteam.edayfashion.models.SignUpParams
import com.crazyteam.edayfashion.services.ApiClient
import com.crazyteam.edayfashion.services.interfaces.IAuthService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object AuthService {
    fun signIn(signInParams: SignInParams) = ApiClient
        .createService(IAuthService::class.java)!!
        .signIn(signInParams)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!

    fun signUp(signUpParams: SignUpParams) = ApiClient
        .createService(IAuthService::class.java)!!
        .signUp(signUpParams)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!
}