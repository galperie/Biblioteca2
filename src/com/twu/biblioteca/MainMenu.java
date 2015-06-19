package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;

/**
 * Created by egalperi on 6/17/15.
 */
public class MainMenu {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    int userInput;

    public MainMenu(PrintStream printStream, BufferedReader bufferedReader) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }
    
    public void printMenuOptions() {
        printStream.println("1. List Books");
    }


    public void startGrabbingMenuOptions() {
        userInput = 0;

        try {
            String inputFromBufferReader = bufferedReader.readLine();
            userInput = Integer.parseInt(inputFromBufferReader);
        }
//        catch (NumberFormatException e){
//
//        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
