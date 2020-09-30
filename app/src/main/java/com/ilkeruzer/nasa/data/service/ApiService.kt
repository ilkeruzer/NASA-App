package com.ilkeruzer.nasa.data.service

import com.ilkeruzer.nasa.model.BaseResponse

class ApiService(private val service: IApiService) {

    fun getCuriosity(
        sol: Int = DEFAULT_SOL,
        page: Int = DEFAULT_PAGE

    ) : ApiServiceGateway<BaseResponse> {
        return ApiServiceGateway(
            service.getCuriosity(sol = sol,page = page)
        )
    }

    companion object {
        const val DEFAULT_SOL = 1000
        const val DEFAULT_PAGE = 1

    }
}
