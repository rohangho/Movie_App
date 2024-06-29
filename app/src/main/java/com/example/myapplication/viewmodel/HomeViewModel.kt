package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.ExampleJsonKtKotlin
import com.example.myapplication.datasoursce.HomeDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel@Inject constructor( val homeDataSource: HomeDataSource): ViewModel() {

    private val _getMovieList : MutableLiveData<ResponseWrapper.Success> = MutableLiveData()
    val getMovieList : LiveData<ResponseWrapper.Success> = _getMovieList



    fun getData(){
        viewModelScope.launch {
           if( homeDataSource.getDataSoursce().isSuccessful)
               Log.e("Hiiiii", "getData: ", )
               _getMovieList.value =
                   ResponseWrapper.Success(homeDataSource.getDataSoursce().body()!!)
        }

    }

}


sealed class ResponseWrapper(){

    data class Success(val data: ExampleJsonKtKotlin): ResponseWrapper()
    data class Error(val message: String): ResponseWrapper()

}