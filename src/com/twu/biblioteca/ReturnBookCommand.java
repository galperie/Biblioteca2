package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by jmann on 6/22/15.
 */
public class ReturnBookCommand implements Command {


    private PrintStream printStream;
    private Biblioteca biblioteca;
    private BufferedReader bufferedReader;

    public ReturnBookCommand(PrintStream printStream, Biblioteca biblioteca, BufferedReader bufferedReader) {

        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void execute() {
        printStream.println("Enter title of book you wish to return: ");

        String title = "";
        try {
            title = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        biblioteca.returnBook(title);
    }
}
