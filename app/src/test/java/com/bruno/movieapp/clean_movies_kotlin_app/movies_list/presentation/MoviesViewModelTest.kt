package com.bruno.movieapp.clean_movies_kotlin_app.movies_list.presentation

import com.bruno.movieapp.clean_movies_kotlin_app.movies_list.ui.model.Movie
import java.util.*

class MoviesViewModelTest {

    fun fakeMovies(): List<Movie> {
        return Arrays.asList(
            Movie(
                "Shazam!",
                listOf("Action", "Comedy", "Adventure", "Fantasy"),
                "en",
                "03/01/2019",
                7.3
            ),
            Movie(
                "Captain Marvel",
                listOf("Action", "Adventure", "Science Fiction"),
                "en",
                "06/03/2019",
                7.2
            ),
            Movie(
                "How to Train Your Dragon: The Hidden World",
                listOf("Animation", "Family", "Adventure"),
                "en",
                "03/01/2019",
                7.6
            )
        )
    }

}