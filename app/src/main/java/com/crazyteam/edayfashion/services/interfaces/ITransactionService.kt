package com.crazyteam.edayfashion.services.interfaces

import com.crazyteam.edayfashion.models.*
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface ITransactionService {

    @POST("/eday/order/addCart")
    fun addCartTransaction(@Body addCartTransactionParams: AddCartTransactionParams): Observable<Response<AddCartTransactionResponse>>

    @GET("/eday/order/addCart")
    fun getOrderListCartTransaction(): Observable<Response<GetOrderListCartTransactionResponse>>

    @GET("/product/{transaction_id}/detail")
    fun getTransactionDetail(@Path("transaction_id") transactionId: Int): Observable<Response<GetTransactionDetailResponse>>

    @GET("/eday/product/list")
    fun getTransactions(): Observable<Response<GetTransactionsResponse>>
}