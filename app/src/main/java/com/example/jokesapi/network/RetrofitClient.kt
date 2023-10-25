package com.example.jokesapi.network

import com.example.jokesapi.BuildConfig.BASE_URL
import com.example.jokesapi.data.remote.JokesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val api = retrofit.create(JokesApi::class.java)
}