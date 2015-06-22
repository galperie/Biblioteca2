package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by egalperi on 6/17/15.
 */
public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu menu;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;
    private final String MENU_OPTION = "1. List Books\n2. Checkout a book\n3. Return a book\n4. Quit\n";
    private final String LIST_BOOKS_OPTION = "1";
    private final String CHECKOUT_OPTION = "2";
    private final String RETURN_BOOK_OPTION = "3";
    private final String QUIT_OPTION = "4";
    private Map<Integer, Command> commandMap;
    private Command returnBookCommand;
    private Command quitCommand;
    private Command listBookCommand;
    private Command checkOutCommand;
    private Command invalidCommand;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        commandMap = new HashMap<Integer, Command>();
        quitCommand = mock(QuitCommand.class);
        checkOutCommand = mock(CheckOutBooksCommand.class);
        listBookCommand = mock(ListBooksCommand.class);
        invalidCommand = mock(InvalidCommand.class);
        returnBookCommand = mock(ReturnBookCommand.class);
        commandMap.put(4, quitCommand);
        commandMap.put(2, checkOutCommand);
        commandMap.put(3, returnBookCommand);
        commandMap.put(1, listBookCommand);
        commandMap.put(0, invalidCommand);
        menu = new MainMenu(printStream, bufferedReader, biblioteca, commandMap);
    }

    @Test
    public void shouldPrintAllMenuOptions() {
        menu.printMenuOptions();

        verify(printStream).println(MENU_OPTION);
    }

    @Test
    public void shouldGrabInputFromBufferedReaderWhenGrabbingUserInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn(LIST_BOOKS_OPTION, QUIT_OPTION);

        menu.getUserMenuOption();

        verify(bufferedReader, times(2)).readLine();
    }

    @Test
    public void shouldOpenTheBibliotecaWhenAppStarts() throws IOException {
        menu.startMenu();

        verify(printStream).println("Welcome to Biblioteca!");
    }

    @Test
    public void shouldTellTheUserToReenterAValidOptionWhenUserInputAnInvalidOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("INVALID", "", null, LIST_BOOKS_OPTION, QUIT_OPTION);

        menu.getUserMenuOption();

        verify(invalidCommand, times(3)).execute();

    }

    @Test
    public void shouldQuitTheAppWhenUserSelectsQuitOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn(QUIT_OPTION);

        menu.getUserMenuOption();

        verify(quitCommand).execute();
    }

    @Test
    public void shouldListBooksWhenUserSelectsListBooksOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn(LIST_BOOKS_OPTION, QUIT_OPTION);

        menu.getUserMenuOption();

        verify(listBookCommand).execute();

    }

    @Test
    public void shouldKeepPromptingUserForInputUntilUserChoosesQuit() throws IOException {
        when(bufferedReader.readLine()).thenReturn(LIST_BOOKS_OPTION, LIST_BOOKS_OPTION, QUIT_OPTION);

        menu.getUserMenuOption();

        verify(printStream, times(2)).println("Please choose a menu option:   ");
    }

    @Test
    public void shouldPromptUserForTheBookToCheckOutWhenUserSelectsCheckoutBookOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn(CHECKOUT_OPTION, QUIT_OPTION);

        menu.getUserMenuOption();

        verify(checkOutCommand).execute();
    }

    @Test
    public void shouldPromptUserToReturnBookWhenUserSelectsReturnBookOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn(RETURN_BOOK_OPTION, QUIT_OPTION);

        menu.getUserMenuOption();

        verify(returnBookCommand).execute();
    }


}