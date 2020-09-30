package com.ilkeruzer.nasa.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilkeruzer.nasa.data.service.ApiService
import com.ilkeruzer.nasa.data.service.IResource
import com.ilkeruzer.nasa.model.BaseResponse
import com.ilkeruzer.nasa.model.Photo

class RoverRepository(
    private val service: ApiService
) {

    fun curiosityLiveData(page: Int): LiveData<ArrayList<Photo?>> {
        val liveData = MutableLiveData<ArrayList<Photo?>>()
        service.getCuriosity(page = page)
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