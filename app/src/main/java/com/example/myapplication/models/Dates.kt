package com.example.myapplication.models

import com.google.gson.annotations.SerializedName


data class Dates (

  @SerializedName("maximum" ) var maximum : String? = null,
  @SerializedName("minimum" ) var minimum : String? = null

)