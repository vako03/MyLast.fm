package com.benten.lastfmapp.domain.models

import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("name")
    val name: String,
    @SerializedName("count")
    val count:Int,
    @SerializedName("reach")
    val reach: Int
)
