package com.example.myapplication.DI

import com.example.myapplication.network.GetMovieList
import com.example.myapplication.network.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule
{

    @Provides
    @Singleton
    fun provideRetrofitInstance(): GetMovieList {
        return RetrofitBuilder.getRetrofitInstance()
    }

}