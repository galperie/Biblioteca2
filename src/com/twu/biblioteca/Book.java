package com.twu.biblioteca;

/**
 * Created by jmann on 6/17/15.
 */
public class Book {
    String title;
    String author;
    String publishedYear;

    public Book(String title, String author, String publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getFormattedBookDetails() {
        return String.format("%-35s %-35s %-35s %n", this.title, this.author, this.publishedYear);
    }

    public String getColumnHeaders() {
        return String.format("%-35s %-35s %-35s %n", "Title", "Author", "Year");
    }
}
