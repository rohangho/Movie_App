package com.example.myapplication.network

import com.example.myapplication.models.ExampleJsonKtKotlin
import retrofit2.Response
import retrofit2.http.GET

interface GetMovieList {

    @GET("3/movie/now_playing?language=en-US&page=1")
    suspend fun getMovieList(): Response<ExampleJsonKtKotlin>

}