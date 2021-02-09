package com.example.minicheckout.repository.network.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TestAPI {

    private const val BASE_URL = "https://fake-mobile-backend.production.stitchfix.com/"

    private val retrofitBuilder: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // This is the API service to call directly or use DI Provider
    val apiService: APIService = retrofitBuilder.create(APIService::class.java)
}