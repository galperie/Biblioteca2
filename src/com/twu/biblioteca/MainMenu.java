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
    public boolean alive;

    public MainMenu(PrintStream printStream, BufferedReader bufferedReader, Biblioteca biblioteca) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.biblioteca = biblioteca;
        this.alive = true;
    }

    public void startMenu() {

        printStream.println("Welcome to Biblioteca!");
        printMenuPrompt();
    }

    public void printMenuPrompt(){
        printStream.println("Please choose a menu option:   ");

    }

    public void printMenuOptions() {

        printStream.println("1. List Books");
    }


    public void getUserInput() {
        int userInput = 0;

        try {
            String inputFromBufferReader = bufferedReader.readLine();
            userInput = Integer.parseInt(inputFromBufferReader);
        }
        catch (NumberFormatException e){
            userInput = -1;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        executeUserRequest(userInput);
    }

    public void executeUserRequest(int userInput) {
        if(userInput==1){
            biblioteca.listBooks();
            printMenuPrompt();
            getUserInput();
        } else if(userInput==2){
            quitMenu();
        } else {
            printStream.print("Select a valid option!   ");
            getUserInput();
        }
    }


    public void quitMenu() {
        alive = false;
    }
}
