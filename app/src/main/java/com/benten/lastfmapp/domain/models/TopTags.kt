package com.benten.lastfmapp.domain.models

import com.google.gson.annotations.SerializedName

data class TopTags(
    @SerializedName("tag")
    val tag:List<Tag>
)
