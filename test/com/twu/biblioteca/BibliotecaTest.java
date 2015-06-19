package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    PrintStream printStream;
    List<Book> books;
    Biblioteca biblioteca;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        biblioteca = new Biblioteca(printStream, books);
    }

    @Test
    public void printWelcomeMessageWhenBibliotecaOpens(){
        biblioteca.openTheBiblioteca();

        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldListNoBooksWhenThereIsNoBook(){
        biblioteca.listBooks();

        verify(printStream, never()).println(anyString());
    }

    @Test
    public void shouldListTheBookNameWhenThereIsOneBook(){
        Book book = mock(Book.class);
        when(book.getFormattedBookDetails()).thenReturn("Book name & detail");
        books.add(book);

        biblioteca.listBooks();

        verify(printStream).println("Book name & detail");
    }

    @Test
    public void shouldListAllBooksNamesWhenThereAreMultipleBooks() {
        Book book = mock(Book.class);
        when(book.getFormattedBookDetails()).thenReturn("Book1 name & detail");
        books.add(book);
        book = mock(Book.class);
        when(book.getFormattedBookDetails()).thenReturn("Book2 name & detail");
        books.add(book);


        biblioteca.listBooks();

        verify(printStream).println("Book1 name & detail");
        verify(printStream).println("Book2 name & detail");
    }

    @Test
    public void shouldPrintFormattedColumnHeaders(){
        String correctHeaders = String.format("%-35s %-35s %-35s %n", "Title", "Author", "Year");

        biblioteca.printColumnHeaders();

        verify(printStream).println(correctHeaders);
    }

}
