package com.benten.lastfmapp.domain.api

import com.benten.lastfmapp.domain.models.GenresResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GenresService {

    @GET("2.0/")
    suspend  fun getTopGenres(
        @Query("method") method: String = "tag.getTopTags",
        @Query("api_key") apiKey: String,
        @Query("format") format: String = "json"
    ): Response<GenresResponseModel>
}