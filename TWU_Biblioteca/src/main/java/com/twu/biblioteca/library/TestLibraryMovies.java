package com.twu.biblioteca.library;

import java.util.List;
import java.util.Optional;

public final class TestLibraryMovies implements Library<Movie> {
    private final List<Movie> movies;

    public TestLibraryMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public List<Movie> getAllItems() {
        return movies;
    }

    @Override
    public Optional<Movie> getItemInfoByItemNo(String itemNo) {
        Optional<Movie> checkMovie = movies.stream().filter(Movie::isIn).filter(movie -> itemNo.equals(movie.getItemNo())).findFirst();
        checkMovie.ifPresent(book -> book.setIn(false));

        return checkMovie;
    }

    @Override
    public boolean returnItemByItemNo(String itemNo) {
        Optional<Movie> checkMovie = movies.stream().filter(movie -> itemNo.equals(movie.getItemNo())).findFirst();
        if(!checkMovie.isPresent() || checkMovie.get().isIn()) {
            return false;
        }
        checkMovie.ifPresent(book -> book.setIn(true));
        return true;
    }
}
