package com.benten.lastfmapp.domain.repositories

import com.benten.lastfmapp.domain.models.GenresResponseModel
import kotlinx.coroutines.flow.Flow

interface GenresRepo {
    suspend fun getTopGenres(apiKey:String): Flow<GenresResponseModel>
}