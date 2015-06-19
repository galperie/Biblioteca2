package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

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
    private final String MENU_OPTION = "1. List Books\n2. Checkout a book\n3. Quit";
    private final String LIST_BOOKS_OPTION = "1";
    private final String CHECKOUT_OPTION = "2";
    private final String QUIT_OPTION = "3";

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = new MainMenu(printStream, bufferedReader, biblioteca);
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
    public void shouldTellTheBibliotecaToListBooksWhenUserInputIsListBooks() throws IOException {
        when(bufferedReader.readLine()).thenReturn(LIST_BOOKS_OPTION, QUIT_OPTION);

        menu.getUserMenuOption();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldTellTheUserToReenterAValidOptionWhenUserInputAnInvalidOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("INVALID", "", null, LIST_BOOKS_OPTION, QUIT_OPTION);

        menu.getUserMenuOption();

        verify(printStream, times(3)).print("Select a valid option!   ");
    }

    @Test
    public void shouldQuitTheAppWhenUserSelectsQuitOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn(QUIT_OPTION);
        menu.getUserMenuOption();
        assertEquals(false, menu.alive);
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

        verify(printStream).println("Please enter the title of the desired book:    ");
    }
}