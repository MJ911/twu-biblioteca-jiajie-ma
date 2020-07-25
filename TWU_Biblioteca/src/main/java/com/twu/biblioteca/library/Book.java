package com.twu.biblioteca.library;

public class Book {
    private String author;
    private int publishYear;

    public Book(String author, int publishYear) {
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
}
