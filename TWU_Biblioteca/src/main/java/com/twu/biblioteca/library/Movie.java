package com.twu.biblioteca.library;

public class Movie extends Item {
    private String movieName;
    private int movieReleaseYear;
    private String movieDirector;
    private String movieRating;

    public Movie(String movieNo, String movieName, int movieReleaseYear, String movieDirector, String movieRating, boolean isIn) {
        super(movieNo, isIn);
        this.movieName = movieName;
        this.movieReleaseYear = movieReleaseYear;
        this.movieDirector = movieDirector;
        this.movieRating = movieRating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieReleaseYear() {
        return movieReleaseYear;
    }

    public void setMovieReleaseYear(int movieReleaseYear) {
        this.movieReleaseYear = movieReleaseYear;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    @Override
    public String toString() {
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s |  %-20s | %-20s\n";
        return String.format(ENTRY_FORMAT, getItemNo(), getMovieName(), getMovieReleaseYear(), getMovieDirector(), getMovieRating());
    }
}
