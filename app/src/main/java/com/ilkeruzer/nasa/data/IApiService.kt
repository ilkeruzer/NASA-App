package com.ilkeruzer.nasa.data

import com.ilkeruzer.nasa.BuildConfig
import com.ilkeruzer.nasa.model.BaseResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    @GET("v1/rovers/curiosity/photos")
    fun getCuriosity(
        @Query("sol") sol: Int,
        @Query("api_key") key: String = BuildConfig.API_KEY,
        @Query("page") page: Int
    ) : Observable<Response<BaseResponse>>

}