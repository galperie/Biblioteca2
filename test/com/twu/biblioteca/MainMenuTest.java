package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by egalperi on 6/17/15.
 */
public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu menu;
    private BufferedReader bufferedReader;
    private Biblioteca biblioteca;

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

        verify(printStream).println("1. List Books");
    }

    @Test
    public void shouldGrabInputFromBufferedReaderWhenGrabbingUserInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.getUserInput();

        verify(bufferedReader).readLine();
    }

//    @Test void shouldReturnNegativeOneWhenThereIsNoInputFromUser() {
//
//    }
//
//    @Test void shouldReturnNegativeOneWhenUserInputIsEmptyString(){
//
//    }
//
//    @Test void shouldReturnNegativeOneWhenUserInputIsNonNumericString(){
//
//    }

    @Test
    public void shouldTellTheBibliotecaToListBooksWhenUserInputIsListBooks() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.getUserInput();

        verify(biblioteca).listBooks();
    }

    @Test
    public void shouldOpenTheBibliotecaWhenAppStarts() throws IOException {
        menu.startMenu();

        verify(printStream).println("Welcome to Biblioteca!\nPlease choose a menu option: ");
    }

}