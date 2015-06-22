package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by jmann on 6/16/15.
 */
public class Biblioteca {
    private PrintStream printStream;
    private List<Book> books;

    public Biblioteca(PrintStream printStream, List<Book> books){
        this.printStream = printStream;
        this.books = books;
    }

    public void listBooks() {
        for(Book book : books){
            if(!book.isCheckedOut) {
                printStream.println(book.getFormattedBookDetails());
            }
        }
    }


    public void printColumnHeaders() {
        printStream.println(String.format("%-35s %-35s %-35s %n", "Title", "Author", "Year"));
    }


    public void checkoutBook(String title) {

        Book book = findBook(title);
        if(book==null || book.isCheckedOut){
            printStream.println("That book is not available.");
        } else {
            printStream.println("Thank you! Enjoy the book!");
            book.isCheckedOut = true;
        }
    }

    public void returnBook(String title) {

        Book book = findBook(title);
        if(book==null || !book.isCheckedOut){
            printStream.println("That is not a valid book to return");
        } else {
            printStream.println("Thank you for returning the book");
            book.isCheckedOut = false;
        }
    }

    private Book findBook(String title) {
        Book bookToFind = null;
        for (Book book : books) {
            if(book.title.equals(title)){
                return book;
            }
        }
        return bookToFind;
    }

}
