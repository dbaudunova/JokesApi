package com.example.jokesapi.presenter

import android.util.Log
import com.example.jokesapi.data.remote.model.Jokes
import com.example.jokesapi.network.RetrofitClient
import com.example.jokesapi.ui.view.JokesView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokesPresenter {

    private lateinit var view: JokesView

    fun attachView(view: JokesView) {
        this.view = view
    }

    fun getData() {
        RetrofitClient().api.getJokes().enqueue(object : Callback<Jokes> {
            override fun onResponse(call: Call<Jokes>, response: Response<Jokes>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        view.showJokes(it)
                    }
                }
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")
            }
        })
    }
}