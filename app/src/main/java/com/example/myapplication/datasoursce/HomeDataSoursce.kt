package com.example.myapplication.datasoursce

import com.example.myapplication.network.GetMovieList
import javax.inject.Inject

class HomeDataSource @Inject constructor(
     val retrofitMovieList: GetMovieList
){
    suspend fun getDataSoursce() = retrofitMovieList.getMovieList()
}



