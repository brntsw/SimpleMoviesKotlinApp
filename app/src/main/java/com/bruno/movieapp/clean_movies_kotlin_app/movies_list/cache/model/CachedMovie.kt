package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.cache.model

data class CachedMovie(
    val movieName: String,
    val genres: List<Int>,
    val originalLanguage: String,
    val releaseDate: String,
    val rating: Double
)