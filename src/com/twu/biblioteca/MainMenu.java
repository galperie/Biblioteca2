package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by egalperi on 6/17/15.
 */
public class MainMenu {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;
    private Map<Integer, Command> commandMap;
    public boolean alive;
    private int quitCommand = 4;
    private int userInput;

    public MainMenu(PrintStream printStream, BufferedReader bufferedReader, Biblioteca biblioteca, Map<Integer, Command> commandMap) {

        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.biblioteca = biblioteca;
        this.commandMap = commandMap;
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

        printStream.println(
                "1. List Books\n" +
                "2. Checkout a book\n" +
                "3. Return a book\n" +
                "4. Quit\n");
    }


    public void getUserMenuOption() {
        userInput = 0;

        try {
            String inputFromBufferReader = bufferedReader.readLine();
            userInput = Integer.parseInt(inputFromBufferReader);
        }
        catch (NumberFormatException e){
            //userInput = -1;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        if(userInput<1 || userInput>4){
            userInput = 0;
        }
        executeUserRequest(userInput);

    }

    public void executeUserRequest(int userInput) {
        commandMap.get(userInput).execute();
        if(userInput!=quitCommand){
            printMenuPrompt();
            getUserMenuOption();
        }
    }
}
