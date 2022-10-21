package com.benten.lastfmapp.domain.repositories

import com.benten.lastfmapp.domain.api.GenresService
import com.benten.lastfmapp.domain.models.GenresResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GenresRepoImpl @Inject constructor(val genresService: GenresService) : GenresRepo {
    override suspend fun getTopGenres(apiKey: String): Flow<GenresResponseModel> = flow {
        val response = genresService.getTopGenres(apiKey = apiKey).body()
        emit(response!!)
    }
}