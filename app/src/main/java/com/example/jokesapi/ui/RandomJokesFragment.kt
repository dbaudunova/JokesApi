package com.example.jokesapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jokesapi.presenter.JokesPresenter
import com.example.jokesapi.ui.view.JokesView
import com.example.jokesapi.data.remote.model.Jokes
import com.example.jokesapi.databinding.FragmentRandomJokesBinding

class RandomJokesFragment : Fragment(), JokesView {

    private lateinit var binding: FragmentRandomJokesBinding
    private val presenter = JokesPresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRandomJokesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        initListener()
    }

    private fun initListener() {
        binding.btnRandom.setOnClickListener {
            presenter.getData()
        }
    }

    override fun showJokes(jokes: Jokes) {
        jokes.body.forEach {
            binding.tvSetup.text = it.setup
            binding.tvPunchline.text = it.punchline
        }
    }
}