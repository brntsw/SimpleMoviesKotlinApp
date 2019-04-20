package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.model

import java.time.LocalDate

data class Movie(
    val movieName: String,
    val genres: List<Int>,
    val originalLanguage: String,
    val releaseDate: LocalDate,
    val rating: Double
)