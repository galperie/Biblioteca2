package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by jmann on 6/22/15.
 */
public class ReturnBookCommand implements Command {


    private PrintStream printStream;
    private Biblioteca biblioteca;

    public ReturnBookCommand(PrintStream printStream, Biblioteca biblioteca) {

        this.printStream = printStream;
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        printStream.println("Enter title of book you wish to return: ");

        biblioteca.returnBook("ABC");
    }
}
