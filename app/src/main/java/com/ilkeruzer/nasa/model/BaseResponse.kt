package com.ilkeruzer.nasa.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class BaseResponse(
    @SerializedName("photos") val photoList: ArrayList<Photo?>
)