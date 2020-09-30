package com.ilkeruzer.nasa.model

import com.google.gson.annotations.SerializedName

data class Camera(
    @SerializedName("name") val name: String
)