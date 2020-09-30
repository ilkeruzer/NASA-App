package com.ilkeruzer.nasa.model

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("photos") val photoList: ArrayList<Photo>
)