package com.twu.biblioteca.libraryTest;

import com.twu.biblioteca.library.Movie;
import com.twu.biblioteca.library.TestLibraryMovies;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class TestLibraryMoviesTest {
    TestLibraryMovies testLibraryMovies;

    @Test
    public void should_get_the_movie_when_user_input_the_existing_movie() {
        List<Movie> movies = Arrays.asList(
                new Movie("1","X MAN", 2001, "Eric", "7", true),
                new Movie("2","X MAN 2", 2004, "Eric & Nick", "9", true),
                new Movie("3","X MAN 3", 2010, "Nick", "10", true));

        testLibraryMovies = new TestLibraryMovies(movies);

        Optional<Movie> exceptedMovie = testLibraryMovies.getItemInfoByItemNo("1");

        exceptedMovie.ifPresent(movie -> assertEquals("1" ,movie.getItemNo()));
        exceptedMovie.ifPresent(movie -> assertEquals("X MAN" ,movie.getMovieName()));
        exceptedMovie.ifPresent(movie -> assertEquals(2001, movie.getMovieReleaseYear()));
        exceptedMovie.ifPresent(movie -> assertEquals("Eric", movie.getMovieDirector()));
        exceptedMovie.ifPresent(movie -> assertEquals("7", movie.getMovieRating()));
        exceptedMovie.ifPresent(movie -> assertFalse(movie.isIn()));
    }
}
