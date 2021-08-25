package com.crazyteam.edayfashion.services

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit : Retrofit? = null

    private val builder = Retrofit.Builder()
        .baseUrl("https://919d-117-2-120-33.ngrok.io")  //url api
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    private val httpClient = OkHttpClient.Builder()

    fun <C> createService(serviceClass: Class<C>) : C? {
        builder.client(httpClient.build())
        retrofit = builder.build()
        return retrofit?.create(serviceClass)
    }

}