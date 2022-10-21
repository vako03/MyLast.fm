package com.benten.lastfmapp.di

import com.benten.lastfmapp.domain.api.GenresService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {

    const val BASE_URL = "http://ws.audioscrobbler.com/"


    @Provides
    @Singleton
    fun provideRetrofitClient(converterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideGenresService(retrofit: Retrofit) = retrofit.create(GenresService::class.java)


    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

}