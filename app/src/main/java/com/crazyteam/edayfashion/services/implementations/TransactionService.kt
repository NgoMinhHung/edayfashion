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

    fun getListCartTransaction() = ApiClient
        .createService(ITransactionService::class.java)!!
        .getOrderListCartTransaction("JSESSIONID=51039C63E8FD801BA88648B0FFA42CAE; refreshToken=def50200fb574daab7efbd7ba7add63c4c2bcf6e99ec14a234471c30b7374e6a3a7c890f148e8f232ca6ba5fd29f56cc6416e137b7ea89b2978f224797e5a76c2ed6da0a473c96f4177d6fb52c81395066a492cc4a52d1e821b229cd05bdd03065ae8380f079ef066faa792b90927a0969344c258dc0dd07e1a24049254fffd42156deba9d1452e6c480d91d23f316a80e3a77daa2378c2b09bd9f3aeb261f3f16761857f422e06d44faaf23b3e9d93e8c4f123d4466798008a59d016fe3ef2528c1ee41f28ca7dcd794364de630555a1fc07924d539f04daea833212c812b2ae12a36623025459e3d8b48f712784b75fd98a72ea585f4302a94f78f8df364b680e07a3db790f041f1e4db817e6235b968ddd5ad3f3e8ab636967606cb6007d922d766a1ca3d57bb6e6e209c412cc023c0076fc9910a4996701d0265c51ea21c5447932f37cc25754f59fd6611e9c977c5ef80874fb0a84e656e54abda1462a532818f")
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())!!
}