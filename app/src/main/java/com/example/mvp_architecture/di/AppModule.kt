package com.example.mvp_architecture.di

import com.example.mvp_architecture.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofitService() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/image")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideAPIService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }
}