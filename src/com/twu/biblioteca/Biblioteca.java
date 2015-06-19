package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by jmann on 6/16/15.
 */
public class Biblioteca {
    PrintStream printStream;
    List<Book> books;

    public Biblioteca(PrintStream printStream, List<Book> books){
        this.printStream = printStream;
        this.books = books;
    }

    public void listBooks() {
        for(Book book : books){
            printStream.println(book.getFormattedBookDetails());
        }
    }

    public void openTheBiblioteca(){
        printStream.println("Welcome to Biblioteca!");
    }

    public void printColumnHeaders() {
        printStream.println(String.format("%-35s %-35s %-35s %n", "Title", "Author", "Year"));
    }
}
