package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.cache

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.cache.mapper.MovieEntityMapper
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.cache.model.CachedMovie
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.model.MovieEntity
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.data.repository.MovieCache
import io.reactivex.Flowable
import java.util.*

class MovieCacheImpl(private val entityMapper: MovieEntityMapper) : MovieCache {

    companion object {
        const val FIELD_MOVIE_NAME = "movie_name"
        const val FIELD_GENRES = "genres"
        const val FIELD_ORIGINAL_LANGUAGE = "original_language"
        const val FIELD_RELEASE_DATE = "release_date"
        const val FIELD_RATING = "rating"
    }

    /** This is the fake database **/
    private var fakeDatabase = ArrayList<List<Pair<String, Any>>>()

    init {
        //Clear each time it is initialized to not duplicating values
        fakeDatabase.clear()

        fakeDatabase.add(
            listOf(Pair(FIELD_MOVIE_NAME, "Shazam!"), Pair(FIELD_GENRES, listOf(28, 35, 12, 14)), Pair(FIELD_ORIGINAL_LANGUAGE, "en"), Pair(FIELD_RELEASE_DATE, "2019-03-01"), Pair(FIELD_RATING, 7.3))
        )

    }

    override fun saveMovies(movies: List<MovieEntity>) {
        movies.forEach { movie ->
            fakeDatabase.add(
                listOf(Pair(FIELD_MOVIE_NAME, movie.movieName), Pair(FIELD_GENRES, movie.genres), Pair(FIELD_ORIGINAL_LANGUAGE, movie.originalLanguage), Pair(FIELD_RELEASE_DATE, movie.releaseDate), Pair(FIELD_RATING, movie.rating))
            )
        }
    }

    override fun getMovies(): Flowable<List<MovieEntity>> {
        val moviesList = mutableListOf<CachedMovie>()

        fakeDatabase.forEach { listPairs ->
            var movieName = ""
            var genres: List<Int> = listOf()
            var originalLanguage = ""
            var releaseDate = ""
            var rating = 0.0

            listPairs.forEach { pair ->
                when(pair.first){
                    FIELD_MOVIE_NAME -> movieName = pair.second as String
                    FIELD_GENRES -> genres = pair.second as List<Int>
                    FIELD_ORIGINAL_LANGUAGE -> originalLanguage = pair.second as String
                    FIELD_RELEASE_DATE -> releaseDate = pair.second as String
                    FIELD_RATING -> rating = pair.second as Double
                }
            }

            moviesList.add(CachedMovie(movieName, genres, originalLanguage, releaseDate, rating))
        }

        return Flowable.defer {
            Flowable.just(moviesList as List<CachedMovie>)
        }.map {
            it.map { entityMapper.mapFromCached(it) }
        }
    }
}