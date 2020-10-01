package com.ilkeruzer.nasa.ui.fragment.curiosity

import androidx.lifecycle.LiveData
import com.ilkeruzer.nasa.data.repository.RoverRepository
import com.ilkeruzer.nasa.model.Photo
import com.ilkeruzer.nasa.ui.BaseViewModel

class CuriosityViewModel(
    private val repository: RoverRepository
) : BaseViewModel() {

    fun getLiveData(page : Int = 1,camera: String? = null): LiveData<ArrayList<Photo?>> {
        return repository.curiosityLiveData(page,camera)
    }
}