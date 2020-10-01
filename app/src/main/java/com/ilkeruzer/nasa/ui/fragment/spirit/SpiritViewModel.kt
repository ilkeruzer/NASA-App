package com.ilkeruzer.nasa.ui.fragment.spirit

import androidx.lifecycle.LiveData
import com.ilkeruzer.nasa.data.repository.RoverRepository
import com.ilkeruzer.nasa.model.Photo
import com.ilkeruzer.nasa.ui.BaseViewModel

class SpiritViewModel(
    private val repository: RoverRepository
) : BaseViewModel() {

    fun testString() : String {
        return "İlker Üzer"
    }

    fun getLiveData(page : Int = 1,camera: String? = null): LiveData<ArrayList<Photo?>> {
        return repository.spiritLiveData(page,camera)
    }
}