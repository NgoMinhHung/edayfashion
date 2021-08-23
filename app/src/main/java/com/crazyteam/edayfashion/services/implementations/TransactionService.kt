package com.crazyteam.edayfashion.services.implementations

import android.content.Context
import com.crazyteam.edayfashion.models.AddCartTransactionParams
import com.crazyteam.edayfashion.services.ApiClient
import com.crazyteam.edayfashion.services.interfaces.ITransactionService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

object TransactionService {

    fun getTransactions() = ApiClient
        .createService(ITransactionService::class.java)!!
        .getTransactions()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!

    fun getTransactionDetail(transactionId: Int) = ApiClient
        .createService(ITransactionService::class.java)!!
        .getTransactionDetail(transactionId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!

    fun addCartTransaction(addCartTransactionParams: AddCartTransactionParams) = ApiClient
        .createService(ITransactionService::class.java)!!
        .addCartTransaction(addCartTransactionParams)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!
}