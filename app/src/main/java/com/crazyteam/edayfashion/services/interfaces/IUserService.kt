package com.crazyteam.edayfashion.services.interfaces

import com.crazyteam.edayfashion.models.GetUserResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface IUserService {

    @GET("/eday/auth/me")
    fun getUser(@Header("Authorization") token: String): Observable<Response<GetUserResponse>>
//
//    @PUT("/api/users/me")
//    fun updateUser(@Header("Authorization") token: String, @Body updateUserParams: UpdateUserParams): Observable<Response<UpdateUserResponse>>
//
//    @PUT("/api/users/me/config")
//    fun updateBudgetConfig(@Header("Authorization") token: String, @Body updateBudgetParams: UpdateBudgetParams): Observable<Response<GetUserResponse>>
}

