package com.ilkeruzer.nasa.ui.fragment.curiosity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilkeruzer.nasa.data.repository.RoverRepository
import com.ilkeruzer.nasa.data.service.ApiService
import com.ilkeruzer.nasa.data.service.IResource
import com.ilkeruzer.nasa.model.BaseResponse
import com.ilkeruzer.nasa.model.Photo
import com.ilkeruzer.nasa.ui.BaseViewModel

class CuriosityViewModel(
    private val repository: RoverRepository
) : BaseViewModel() {

    fun testString(): String {
        return "İlker ÜZer"
    }

    fun getLiveData(page : Int = 1,camera: String? = null): LiveData<ArrayList<Photo?>> {
        return repository.curiosityLiveData(page,camera)
    }
}