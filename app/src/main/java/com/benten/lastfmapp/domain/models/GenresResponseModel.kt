package com.benten.lastfmapp.domain.models

import com.google.gson.annotations.SerializedName

data class GenresResponseModel(
    @SerializedName("toptags")
    val toptags: TopTags
)
