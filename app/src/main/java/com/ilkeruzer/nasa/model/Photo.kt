package com.ilkeruzer.nasa.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id") val id: Int,
    @SerializedName("img_src") val img_src: String
)