package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by jmann on 6/22/15.
 */
public class ReturnBookCommand implements Command {


    private PrintStream printStream;

    public ReturnBookCommand(PrintStream printStream) {

        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.println("Enter title of book you wish to return: ");
    }
}
