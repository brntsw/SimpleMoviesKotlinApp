package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.model.MovieEntity
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.model.Movie
import java.time.LocalDate

class MovieMapper : Mapper<MovieEntity, Movie> {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun mapFromEntity(type: MovieEntity): Movie {
        return Movie(type.movieName, type.genres, type.originalLanguage, LocalDate.parse(type.releaseDate), type.rating)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun mapToEntity(type: Movie): MovieEntity {
        return MovieEntity(type.movieName, type.genres, type.originalLanguage, "${type.releaseDate.year}-${type.releaseDate.month}-${type.releaseDate.dayOfMonth}", type.rating)
    }
}