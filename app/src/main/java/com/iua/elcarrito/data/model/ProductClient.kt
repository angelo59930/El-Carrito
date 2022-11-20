package com.iua.elcarrito.data.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductClient {
  private val retrofit : Retrofit = Retrofit.Builder().
    baseUrl("https://mocki.io/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

  val service: ProductService = retrofit.create(ProductService::class.java)
}