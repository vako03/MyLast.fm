package com.benten.lastfmapp.presentation.models

import com.benten.lastfmapp.domain.models.Tag
import com.google.gson.annotations.SerializedName

data class TopTags(
    @SerializedName("tag")
    val tag:List<Tag>
)
