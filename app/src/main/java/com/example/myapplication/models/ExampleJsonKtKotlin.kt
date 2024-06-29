package com.example.myapplication.models

import com.google.gson.annotations.SerializedName


data class ExampleJsonKtKotlin (

  @SerializedName("dates"         ) var dates        : Dates?             = Dates(),
  @SerializedName("page"          ) var page         : Int?               = null,
  @SerializedName("results"       ) var results      : ArrayList<Results> = arrayListOf(),
  @SerializedName("total_pages"   ) var totalPages   : Int?               = null,
  @SerializedName("total_results" ) var totalResults : Int?               = null

)