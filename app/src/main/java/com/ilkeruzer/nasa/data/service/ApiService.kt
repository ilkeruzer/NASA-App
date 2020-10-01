package com.ilkeruzer.nasa.data.service

import com.ilkeruzer.nasa.model.BaseResponse

class ApiService(private val service: IApiService) {

    fun getCuriosity(
        sol: Int = DEFAULT_SOL,
        page: Int = DEFAULT_PAGE,
        camera: String? = DEFAULT_CAMERA

    ) : ApiServiceGateway<BaseResponse> {
        return ApiServiceGateway(
            service.getCuriosity(sol = sol,page = page,camera = camera)
        )
    }

    fun getOpportunity(
        sol: Int = DEFAULT_SOL,
        page: Int = DEFAULT_PAGE,
        camera: String? = DEFAULT_CAMERA

    ) : ApiServiceGateway<BaseResponse> {
        return ApiServiceGateway(
            service.getOpportunity(sol = sol,page = page,camera = camera)
        )
    }

    fun getSpirit(
        sol: Int = DEFAULT_SOL,
        page: Int = DEFAULT_PAGE,
        camera: String? = DEFAULT_CAMERA

    ) : ApiServiceGateway<BaseResponse> {
        return ApiServiceGateway(
            service.getSpirit(sol = sol,page = page,camera = camera)
        )
    }

    companion object {
        const val DEFAULT_SOL = 1000
        const val DEFAULT_PAGE = 1
        val DEFAULT_CAMERA : String? = null
    }
}
