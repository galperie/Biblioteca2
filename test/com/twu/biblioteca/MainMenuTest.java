package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by egalperi on 6/17/15.
 */
public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu menu;
    private BufferedReader bufferedReader;

    @Before
    public void setup(){
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        menu = new MainMenu(printStream, bufferedReader);
    }

    @Test
    public void shouldPrintAllMenuOptions() {
        menu.printMenuOptions();

        verify(printStream).println("1. List Books");
    }

    @Test
    public void shouldGrabInputFromBufferedReaderWhenGrabbingUserInput() throws IOException {
        menu.startGrabbingMenuOptions();

        verify(bufferedReader).readLine();
    }

    @Test void shouldReturnNegativeOneWhenThereIsNoInputFromUser() {

    }

    @Test void shouldReturnNegativeOneWhenUserInputIsEmptyString(){

    }

    @Test void shouldReturnNegativeOneWhenUserInputIsNonNumericString(){

    }

}