package com.twu.biblioteca;

/**
 * Created by jmann on 6/17/15.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private String title = "ABC";
    private String author = "Person";
    private String year = "2000";
    private Book book;

    @Before
    public void setup(){
        title = "ABC";
        author = "Person";
        year = "2000";
        book = new Book(title, author, year);
    }

    @Test
    public void shouldReturnFormattedBookDetails(){
        String correctFormattedDetails = String.format("%-15s %-15s %-30s %n", title, author, year);

        assertEquals(book.getFormattedBookDetails(), correctFormattedDetails);
    }

    @Test
    public void shouldReturnFormattedColumnHeaders(){
        String correctFormattedDetails = String.format("%-15s %-15s %-30s %n", "Title", "Author", "Year");

        assertEquals(book.getColumnHeaders(), correctFormattedDetails);
    }
}
