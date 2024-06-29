package com.example.myapplication.network

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {

    fun setClient() =
        OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNjg4ZTI4MWRjYTVmOWM0NGY4NzFhNmVhYTJmODMxMCIsIm5iZiI6MTcxOTU2NTAzMS4zODgzNDcsInN1YiI6IjY2N2U3YTcyZGI2Njc1YzMyYjhkNzI0NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.aZtcEIuonqZH3BFArwQ3Z0QX5ysYpPaUglyINAFuLBo")
                .build()
            chain.proceed(newRequest)
        }.build()


    fun getRetrofitInstance() =

        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory( GsonConverterFactory.create()).client(setClient())
            .build().create(GetMovieList::class.java)
}