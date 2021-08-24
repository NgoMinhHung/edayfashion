package com.crazyteam.edayfashion.services.interfaces

import com.crazyteam.edayfashion.models.GetUserResponse
import com.crazyteam.edayfashion.models.UpdateUserParams
import com.crazyteam.edayfashion.models.UpdateUserResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface IUserService {

    @GET("/eday/auth/me")
    fun getUser(@Header("Cookie") cookie: String): Observable<Response<GetUserResponse>>

    @POST("/eday/userAu/editProfile")
    fun updateUser(@Header("Cookie") cookie: String, @Body updateUserParams: UpdateUserParams): Observable<Response<UpdateUserResponse>>
//
//    @PUT("/api/users/me/config")
//    fun updateBudgetConfig(@Header("Authorization") token: String, @Body updateBudgetParams: UpdateBudgetParams): Observable<Response<GetUserResponse>>
}

