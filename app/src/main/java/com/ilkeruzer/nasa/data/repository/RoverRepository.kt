package com.ilkeruzer.nasa.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilkeruzer.nasa.data.service.ApiService
import com.ilkeruzer.nasa.data.service.IResource
import com.ilkeruzer.nasa.model.BaseResponse
import com.ilkeruzer.nasa.model.Camera
import com.ilkeruzer.nasa.model.Photo

class RoverRepository(
    private val service: ApiService
) {

    fun curiosityLiveData(page: Int,camera: String? = null): LiveData<ArrayList<Photo?>> {
        val liveData = MutableLiveData<ArrayList<Photo?>>()
        service.getCuriosity(page = page,camera = camera)
            .apiResponse(object : IResource<BaseResponse> {
                override fun onSuccess(t: BaseResponse) {
                    liveData.postValue(t.photoList)
                }

                override fun onFailed() {
                    Log.e("CuriosityViewModel", "onFailed: ")
                }

            })
        return liveData
    }

    fun opportunityLiveData(page: Int,camera: String? = null): LiveData<ArrayList<Photo?>> {
        val liveData = MutableLiveData<ArrayList<Photo?>>()
        service.getOpportunity(page = page,camera = camera)
            .apiResponse(object : IResource<BaseResponse> {
                override fun onSuccess(t: BaseResponse) {
                    liveData.postValue(t.photoList)
                }

                override fun onFailed() {
                    Log.e("CuriosityViewModel", "onFailed: ")
                }

            })
        return liveData
    }

    fun spiritLiveData(page: Int,camera: String? = null): LiveData<ArrayList<Photo?>> {
        val liveData = MutableLiveData<ArrayList<Photo?>>()
        service.getSpirit(page = page,camera = camera)
            .apiResponse(object : IResource<BaseResponse> {
                override fun onSuccess(t: BaseResponse) {
                    liveData.postValue(t.photoList)
                }

                override fun onFailed() {
                    Log.e("CuriosityViewModel", "onFailed: ")
                }

            })
        return liveData
    }
}