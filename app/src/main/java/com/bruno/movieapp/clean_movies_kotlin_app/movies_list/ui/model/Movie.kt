package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.ui.model

data class Movie(
    val movieName: String,
    val genres: List<String>,
    val originalLanguage: String,
    val releaseDate: String,
    val rating: Double
)