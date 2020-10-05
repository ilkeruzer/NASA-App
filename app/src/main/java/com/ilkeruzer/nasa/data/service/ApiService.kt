package com.ilkeruzer.nasa.data.service

import com.ilkeruzer.nasa.model.BaseResponse

class ApiService(private val service: IApiService) {

    fun getCuriosity(
        page: Int = DEFAULT_PAGE,
        camera: String? = DEFAULT_CAMERA

    ) : ApiServiceGateway<BaseResponse> {
        return ApiServiceGateway(
            service.getCuriosity(page = page,camera = camera)
        )
    }

    fun getOpportunity(
        page: Int = DEFAULT_PAGE,
        camera: String? = DEFAULT_CAMERA

    ) : ApiServiceGateway<BaseResponse> {
        return ApiServiceGateway(
            service.getOpportunity(page = page,camera = camera)
        )
    }

    fun getSpirit(
        page: Int = DEFAULT_PAGE,
        camera: String? = DEFAULT_CAMERA

    ) : ApiServiceGateway<BaseResponse> {
        return ApiServiceGateway(
            service.getSpirit(page = page,camera = camera)
        )
    }

    companion object {
        const val DEFAULT_PAGE = 1
        val DEFAULT_CAMERA : String? = null
    }
}
