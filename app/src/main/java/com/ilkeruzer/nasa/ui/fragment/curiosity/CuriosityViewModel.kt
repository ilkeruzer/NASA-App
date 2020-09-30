package com.ilkeruzer.nasa.ui.fragment.curiosity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilkeruzer.nasa.data.ApiService
import com.ilkeruzer.nasa.data.IResource
import com.ilkeruzer.nasa.model.BaseResponse
import com.ilkeruzer.nasa.ui.BaseViewModel

class CuriosityViewModel(
    private val service: ApiService
) : BaseViewModel() {

    fun testString(): String {
        return "İlker ÜZer"
    }

    fun testLiveData(): LiveData<BaseResponse> {
        val liveData = MutableLiveData<BaseResponse>()
        service.getCuriosity()
            .apiResponse(object : IResource<BaseResponse> {
                override fun onSuccess(t: BaseResponse) {
                    liveData.postValue(t)
                }

                override fun onFailed() {
                    Log.e("CuriosityViewModel", "onFailed: ")
                }

            })
        return liveData
    }
}