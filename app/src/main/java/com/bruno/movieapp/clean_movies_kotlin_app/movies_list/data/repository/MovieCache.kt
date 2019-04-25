package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.repository

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.model.MovieEntity
import io.reactivex.Flowable

interface MovieCache {

    fun saveMovies(movies: List<MovieEntity>)

    fun getMovies(): Flowable<List<MovieEntity>>

}