package com.twu.biblioteca.library;

public class movie extends item {
    private String movieName;
    private String movieReleaseYear;
    private String movieDirector;
    private String movieRating;

    public movie(String movieNo, String movieName, String movieReleaseYear, String movieDirector, String movieRating, boolean isIn) {
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

    public String getMovieReleaseYear() {
        return movieReleaseYear;
    }

    public void setMovieReleaseYear(String movieReleaseYear) {
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
}
