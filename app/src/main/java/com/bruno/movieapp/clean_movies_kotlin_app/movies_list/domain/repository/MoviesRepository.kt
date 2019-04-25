package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.repository

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.model.Movie
import io.reactivex.Flowable

interface MoviesRepository {

    fun getMovies(): Flowable<List<Movie>>

}