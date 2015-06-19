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
    private Biblioteca biblioteca;
    int userInput;

    public MainMenu(PrintStream printStream, BufferedReader bufferedReader, Biblioteca biblioteca) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.biblioteca = biblioteca;
    }
    
    public void printMenuOptions() {

        printStream.println("1. List Books");
    }


    public void getUserInput() {
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

        executeUserRequest(userInput);
    }

    public void executeUserRequest(int userInput) {
        if(userInput==1){
            biblioteca.listBooks();
        }
    }

    public void startMenu() {
        printStream.println("Welcome to Biblioteca!\nPlease choose a menu option: ");
    }
}
