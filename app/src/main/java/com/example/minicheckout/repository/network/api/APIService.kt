package com.example.minicheckout.repository.network.api

import com.example.minicheckout.repository.network.data.BoxResponse
import io.reactivex.Single
import retrofit2.http.GET

interface APIService {
    //Function to get the API response
    @GET("api/current_fix")
    fun currentFix(): Single<BoxResponse>
}