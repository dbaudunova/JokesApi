package com.example.jokesapi.data.remote.model

import com.google.gson.annotations.SerializedName

data class Jokes(
    val success: Boolean,
    val body: List<Body>
) {
    data class Body(
        @SerializedName("_id")
        val id: String,
        val setup: String,
        val punchline: String,
        val type: String,
        val likes: List<Any>,
        val author: Author,
        val approved: Boolean,
        val date: Int,
        @SerializedName("NSFW")
        val nsfw: Boolean,
        val shareableLink: String
    ) {
        data class Author(
            val name: String,
            val id: Any
        )
    }
}