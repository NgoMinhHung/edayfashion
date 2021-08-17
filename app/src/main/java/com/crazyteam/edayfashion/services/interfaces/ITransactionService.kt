package com.crazyteam.edayfashion.services.interfaces

//import com.crazyteam.edayfashion.models.CreateTransactionParams
//import com.crazyteam.edayfashion.models.CreateTransactionResponse
//import com.crazyteam.edayfashion.models.GetTransactionsResponse
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface ITransactionService {

//    @PUT("/api/users/me/transaction_items/{transaction_id}")
//    fun updateTransaction(@Header("Authorization") token: String, @Path("transaction_id") transactionId: Int, @Body createTransactionParams: CreateTransactionParams): Observable<Response<CreateTransactionResponse>>
//
//    @DELETE("/api/users/me/transaction_items/{transaction_id}")
//    fun deleteTransaction(@Header("Authorization") token: String, @Path("transaction_id") transactionId: Int): Observable<Response<ResponseBody>>
//
//    @POST("/api/users/me/transaction_items")
//    fun createTransaction(@Header("Authorization") token: String, @Body createTransactionParams: CreateTransactionParams): Observable<Response<CreateTransactionResponse>>
//
//    @GET("/api/users/me/transaction_items")
//    fun getTransactions(@Header("Authorization") token: String, @Query("date") date: Date, @Query("type") type: String): Observable<Response<GetTransactionsResponse>>
}