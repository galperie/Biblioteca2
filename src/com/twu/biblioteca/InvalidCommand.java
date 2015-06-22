package com.twu.biblioteca;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.io.PrintStream;

/**
 * Created by jmann on 6/19/15.
 */
public class InvalidCommand implements Command {
    private PrintStream printStream;

    public InvalidCommand(PrintStream printStream){
        this.printStream = printStream;
    }

    @Override
    public void execute() {
        printStream.print("Select a valid option!   ");
    }
}
