package com.twu.biblioteca.library;

public class Book {
    private String bookNo;
    private String author;
    private int publishYear;
    private boolean isIn;

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
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

    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }

    @Override
    public String toString() {
        final String ENTRY_FORMAT = "%-16s | %-20s | %-20s\n";
        return String.format(ENTRY_FORMAT, getBookNo(), getAuthor(), getPublishYear());
    }
}
