package com.example.jokesapi.data.remote

import com.example.jokesapi.data.remote.model.Jokes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface JokesApi {

    @GET("random/joke")
    fun getJokes(
        @Header("X-RapidAPI-Key") key: String = "186d9acc0amsh888246f50512b8fp17af75jsnc0715800b4f5",
        @Header("X-RapidAPI-Host") host: String = "dad-jokes.p.rapidapi.com"
    ): Call<Jokes>
}