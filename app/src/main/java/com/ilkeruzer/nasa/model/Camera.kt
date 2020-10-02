package com.ilkeruzer.nasa.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Camera(
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val full_name: String
) : Parcelable