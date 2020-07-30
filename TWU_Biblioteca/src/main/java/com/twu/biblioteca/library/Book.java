package com.twu.biblioteca.library;

public class Book extends Item {
    private String author;
    private int publishYear;

    public Book(String bookNo, String author, int publishYear, boolean isIn) {
        super(bookNo, isIn);
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

    @Override
    public String toString() {
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s\n";
        return String.format(ENTRY_FORMAT, getItemNo(), getAuthor(), getPublishYear());
    }
}
