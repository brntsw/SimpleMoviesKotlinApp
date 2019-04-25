package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.source

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.cache.MovieCacheImpl
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.cache.mapper.MovieEntityMapper
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.repository.MoviesDataStore

class MovieDataStoreFactory {

    fun retrieveCacheDataStore(): MoviesDataStore {
        return MovieCacheDataStore(MovieCacheImpl(MovieEntityMapper()))
    }

}