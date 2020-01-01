package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.use_case

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.model.Movie
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.repository.MoviesRepository
import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.domain.interactor.use_case.GetMoviesUseCase
import com.nhaarman.mockitokotlin2.verify
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDate
import java.util.*
import kotlin.test.assertEquals

@ExtendWith(MockKExtension::class)
class MoviesTest {

    init {
        MockKAnnotations.init(this)
    }

    private val movies: List<Movie> = fakeMovies()

    @MockK
    lateinit var repository: MoviesRepository

    private val getMoviesUseCase = GetMoviesUseCase(repository)

    @Test
    fun `Check if the movies attributes are correct`(){
        val firstMovie = movies[0]
        assertEquals(firstMovie.movieName, "Shazam!")
        assertEquals(firstMovie.genres, listOf(28, 35, 12, 14))
        assertEquals(firstMovie.originalLanguage, "en")
        assertEquals(firstMovie.releaseDate, LocalDate.parse("2019-03-01"))
        assertEquals(firstMovie.rating, 7.3)
    }

    @Test
    fun `Build use case calling the repository`(){
        getMoviesUseCase.getSingleMovies()
        verify(repository).getMovies() //TODO solve -> no answer found for: MoviesRepository(repository#1).getMovies() || Implement the repository in order to obtain data
    }

    private fun fakeMovies(): List<Movie> {
        return listOf(Movie(
                "Shazam!",
                listOf(28, 35, 12, 14),
                "en",
                LocalDate.parse("2019-03-01"),
                7.3
            ), Movie(
                "Captain Marvel",
                listOf(28, 12, 878),
                "en",
                LocalDate.parse("2019-03-06"),
                7.2
            ), Movie(
                "How to Train Your Dragon: The Hidden World",
                listOf(16, 10751, 12),
                "en",
                LocalDate.parse("2019-01-03"),
                7.6
            ))
    }

}