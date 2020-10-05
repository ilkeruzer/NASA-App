package com.ilkeruzer.nasa.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@JsonIgnoreProperties(ignoreUnknown = true)
@Parcelize
data class Camera(
    @SerializedName("name") val name: String,
    @SerializedName("full_name") val full_name: String
) : Parcelable