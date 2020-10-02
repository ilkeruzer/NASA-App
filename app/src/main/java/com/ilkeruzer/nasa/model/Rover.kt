package com.ilkeruzer.nasa.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rover(
    @SerializedName("name") val name: String,
    @SerializedName("landing_date") val landing_date: String,
    @SerializedName("launch_date") val launch_date: String,
    @SerializedName("status") val status: String
) : Parcelable