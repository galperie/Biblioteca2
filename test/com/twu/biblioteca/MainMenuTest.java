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
    private final String MENU_OPTION = "1. List Books";

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
        when(bufferedReader.readLine()).thenReturn("1");
        menu.getUserInput();

        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldOpenTheBibliotecaWhenAppStarts() throws IOException {
        menu.startMenu();

        verify(printStream).println("Welcome to Biblioteca!\nPlease choose a menu option: ");
    }

    @Test
    public void shouldTellTheBibliotecaToListBooksWhenUserInputIsListBooks() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.getUserInput();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldTellTheUserToReenterAValidOptionWhenUserInputAnInvalidOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("INVALID", "", null, "1");
        menu.getUserInput();

        verify(printStream, times(3)).print("Select a valid option!   ");
    }

    @Test
    public void shouldQuitTheAppWhenUserSelectsQuitOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        menu.getUserInput();
        assertEquals(false, menu.alive);
    }

    @Test
    public void shouldKeepPromptingUserForInputUntilUserChoosesQuit() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1", "1", "2");
        menu.getUserInput();

        verify(printStream, times(2)).println("Please choose a menu option:   ");
    }
}