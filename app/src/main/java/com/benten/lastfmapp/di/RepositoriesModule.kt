package com.benten.lastfmapp.di

import com.benten.lastfmapp.domain.api.GenresService
import com.benten.lastfmapp.domain.repositories.GenresRepo
import com.benten.lastfmapp.domain.repositories.GenresRepoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun provideGenresRepo(genresRepoImpl: GenresRepoImpl): GenresRepo

    companion object {
        @Provides
        fun getGenresRepoImpl(genresService: GenresService): GenresRepoImpl {
            return GenresRepoImpl(genresService)
        }
    }
}