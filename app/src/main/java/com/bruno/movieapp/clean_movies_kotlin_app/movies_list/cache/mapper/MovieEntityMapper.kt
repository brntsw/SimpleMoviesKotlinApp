package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.cache.mapper

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.cache.model.CachedMovie
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.model.MovieEntity

class MovieEntityMapper : EntityMapper<CachedMovie, MovieEntity> {

    override fun mapFromCached(type: CachedMovie): MovieEntity {
        return MovieEntity(type.movieName, type.genres, type.originalLanguage, type.releaseDate, type.rating)
    }

    override fun mapToCached(type: MovieEntity): CachedMovie {
        return CachedMovie(type.movieName, type.genres, type.originalLanguage, type.releaseDate, type.rating)
    }

}