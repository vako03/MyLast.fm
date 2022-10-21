package com.benten.lastfmapp.domain.models

import com.benten.lastfmapp.presentation.models.TopTags
import com.google.gson.annotations.SerializedName

data class GenresResponseModel(
    @SerializedName("toptags")
    val toptags: TopTags

)
