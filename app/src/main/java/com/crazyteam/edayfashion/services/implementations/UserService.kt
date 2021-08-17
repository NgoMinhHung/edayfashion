package com.crazyteam.edayfashion.services.implementations

import android.content.Context
import com.crazyteam.edayfashion.services.ApiClient
import com.crazyteam.edayfashion.services.interfaces.IUserService
import com.crazyteam.edayfashion.utils.getToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object UserService {
//    fun getUser(context: Context) = ApiClient
//        .createService(IUserService::class.java)!!
//        .getUser(context.getToken()!!)
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribeOn(Schedulers.io())!!

//    fun updateUser(context: Context, updateUserParams: UpdateUserParams) = ApiClient
//        .createService(IUserService::class.java)!!
//        .updateUser(context.getToken()!!, updateUserParams)
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribeOn(Schedulers.io())!!
//
//    fun updateBudgetConfig(context: Context, updateBudgetParams: UpdateBudgetParams) = ApiClient
//        .createService(IUserService::class.java)!!
//        .updateBudgetConfig(context.getToken()!!, updateBudgetParams)
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribeOn(Schedulers.io())!!
}