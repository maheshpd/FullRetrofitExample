package com.createsapp.retrofitexample.api

import com.createsapp.retrofitexample.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("quotess")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>
}