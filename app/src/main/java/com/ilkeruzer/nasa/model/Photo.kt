package com.ilkeruzer.nasa.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    @SerializedName("id") val id: Int,
    @SerializedName("img_src") val img_src: String,
    @SerializedName("camera") val camera: Camera,
    @SerializedName("earth_date") val earth_date: String,
    @SerializedName("rover") val rover: Rover
) : Parcelable