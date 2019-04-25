package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.source

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.model.MovieEntity
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.repository.MovieCache
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.repository.MoviesDataStore
import io.reactivex.Flowable

class MovieCacheDataStore(private val movieCache: MovieCache):
        MoviesDataStore {

    override fun saveMovies(movies: List<MovieEntity>) {
        movieCache.saveMovies(movies)
    }

    override fun getMovies(): Flowable<List<MovieEntity>> = movieCache.getMovies()


}