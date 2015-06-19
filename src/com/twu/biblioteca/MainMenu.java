package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

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

        printStream.println("1. List Books\n2. Checkout a book\n3. Quit");
    }


    public void getUserMenuOption() {
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
        if(userInput==1) {
            biblioteca.listBooks();
            printMenuPrompt();
            getUserMenuOption();
        }
        else if(userInput == 2) {
            checkoutBookProcess();
            getUserMenuOption();
        }
        else if(userInput==3) {
            quitMenu();
        } else {
            printStream.print("Select a valid option!   ");
            getUserMenuOption();
        }
    }

    private void checkoutBookProcess() {
        printStream.println("Please enter the title of the desired book:    ");
        String userInput = "";
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        biblioteca.checkoutBook(userInput);
    }

    public void quitMenu() {
        alive = false;
    }
}
