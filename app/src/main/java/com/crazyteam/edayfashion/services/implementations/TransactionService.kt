package com.minhhung.life_app.services.implementations

import android.content.Context
import com.minhhung.life_app.models.CreateTransactionParams
import com.minhhung.life_app.services.ApiClient
import com.minhhung.life_app.services.interfaces.ITransactionService
import com.minhhung.life_app.utils.getToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

object TransactionService {
    fun createTransaction(context: Context, createTransactionParams: CreateTransactionParams) = ApiClient
        .createService(ITransactionService::class.java)!!
        .createTransaction(context.getToken()!!, createTransactionParams)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!

    fun updateTransaction(context: Context, transactionId: Int, createTransactionParams: CreateTransactionParams) = ApiClient
        .createService(ITransactionService::class.java)!!
        .updateTransaction(context.getToken()!!, transactionId, createTransactionParams)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!

    fun deleteTransaction(context: Context, transactionId: Int) = ApiClient
        .createService(ITransactionService::class.java)!!
        .deleteTransaction(context.getToken()!!, transactionId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!

    fun getTransactions(context: Context, date: Date, type: String) = ApiClient
        .createService(ITransactionService::class.java)!!
        .getTransactions(context.getToken()!!, date, type)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!
}