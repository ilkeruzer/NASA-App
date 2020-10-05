package com.ilkeruzer.nasa.data.service

import com.ilkeruzer.nasa.BuildConfig
import com.ilkeruzer.nasa.model.BaseResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    @GET("v1/rovers/curiosity/photos")
    fun getCuriosity(
        @Query("camera") camera: String?,
        @Query("sol") sol: Int = DEFAULT_SOL,
        @Query("api_key") key: String = API,
        @Query("page") page: Int
    ) : Observable<Response<BaseResponse>>

    @GET("v1/rovers/opportunity/photos")
    fun getOpportunity(
        @Query("camera") camera: String?,
        @Query("sol") sol: Int = DEFAULT_SOL,
        @Query("api_key") key: String = API,
        @Query("page") page: Int
    ) : Observable<Response<BaseResponse>>

    @GET("v1/rovers/spirit/photos")
    fun getSpirit(
        @Query("camera") camera: String?,
        @Query("sol") sol: Int = DEFAULT_SOL,
        @Query("api_key") key: String = API,
        @Query("page") page: Int
    ) : Observable<Response<BaseResponse>>

    companion object {
        const val DEFAULT_SOL = 1000
        const val API = BuildConfig.API_KEY
    }
}
