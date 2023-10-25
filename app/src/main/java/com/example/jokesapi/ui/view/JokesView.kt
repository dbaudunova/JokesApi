package com.example.jokesapi.ui.view

import com.example.jokesapi.data.remote.model.Jokes

interface JokesView {

    fun showJokes(jokes: Jokes)
}