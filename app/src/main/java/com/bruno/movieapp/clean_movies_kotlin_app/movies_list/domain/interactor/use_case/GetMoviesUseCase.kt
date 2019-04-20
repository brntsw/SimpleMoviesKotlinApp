package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.interactor.use_case

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.model.Movie
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.repository.MoviesRepository
import io.reactivex.Single

class GetMoviesUseCase(private val repository: MoviesRepository) {

    fun getSingleMovies(): Single<List<Movie>>{
        return repository.getMovies()
    }
}