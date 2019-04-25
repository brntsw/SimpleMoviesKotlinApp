package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.interactor.use_case

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.model.Movie
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.repository.MoviesRepository
import io.reactivex.Flowable

class GetMoviesUseCase(private val repository: MoviesRepository) {

    fun getSingleMovies(): Flowable<List<Movie>>{
        return repository.getMovies()
    }
}