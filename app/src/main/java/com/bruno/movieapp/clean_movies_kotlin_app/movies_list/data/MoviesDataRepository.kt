package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.mapper.MovieMapper
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.source.MovieDataStoreFactory
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.model.Movie
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.repository.MoviesRepository
import io.reactivex.Flowable

class MoviesDataRepository(private val factory: MovieDataStoreFactory,
                           private val movieMapper: MovieMapper) : MoviesRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getMovies(): Flowable<List<Movie>> {
        return factory.retrieveCacheDataStore().getMovies()
            .flatMap { listMovies ->
                Flowable.just(listMovies.map { movieMapper.mapFromEntity(it) })
            }
    }
}