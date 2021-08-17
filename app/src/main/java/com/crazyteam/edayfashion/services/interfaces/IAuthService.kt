package com.crazyteam.edayfashion.services.interfaces

import com.crazyteam.edayfashion.models.*
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface IAuthService {

    @POST("eday/auth/signin")
    fun signIn(@Body signInParams: SignInParams): Observable<Response<SignInResponse>>

    @POST("eday/signup")
    fun signUp(@Body signUpParams: SignUpParams): Observable<Response<SignUpResponse>>

}