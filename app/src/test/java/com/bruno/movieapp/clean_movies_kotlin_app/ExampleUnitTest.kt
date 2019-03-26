package com.bruno.movieapp.clean_movies_kotlin_app

import org.junit.Assert.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Nested
    inner class NumberChecks{
        @Test
        fun `Addition is correct`() {
            assertEquals(4, 2 + 2)
        }

        @Test
        fun `Check if addition and division are correct`(){
            assertEquals(2, (2+2)/2)
        }
    }

    @Nested
    inner class StringChecks{
        @Test
        fun `Check if string is the same`(){
            assertEquals("a string", "a string")
        }
    }
}
