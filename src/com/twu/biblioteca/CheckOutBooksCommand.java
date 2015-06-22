package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by jmann on 6/19/15.
 */
public class CheckOutBooksCommand implements Command {
    private Biblioteca biblioteca;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public CheckOutBooksCommand(Biblioteca biblioteca, PrintStream printStream, BufferedReader bufferedReader){
        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void execute() {
        printStream.println("Please enter the title of the desired book:    ");
        String userInput = "";
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        biblioteca.checkoutBook(userInput);
    }
}
