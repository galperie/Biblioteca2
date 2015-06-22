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
 * Created by jmann on 6/22/15.
 */
public class ReturnBookCommandTest {

    private PrintStream printStream;
    private Command returnBookCommand;
    private Biblioteca biblioteca;
    private BufferedReader bufferedReader;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        bufferedReader = mock(BufferedReader.class);
        returnBookCommand = new ReturnBookCommand(printStream, biblioteca, bufferedReader);
    }

    @Test
    public void shouldPromptUserWithBookTitleToReturnWhenUserIsReturningABook(){
        returnBookCommand.execute();

        verify(printStream).println("Enter title of book you wish to return: ");
    }

    @Test
    public void shouldReturnBookWhenUserIsReturningBook() throws IOException {
        when(bufferedReader.readLine()).thenReturn("ABC");
        returnBookCommand.execute();

        verify(biblioteca).returnBook("ABC");
    }

}