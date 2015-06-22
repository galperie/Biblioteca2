package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by jmann on 6/22/15.
 */
public class ReturnBookCommandTest {

    private PrintStream printStream;
    private Command returnBookCommand;
    private Biblioteca biblioteca;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        returnBookCommand = new ReturnBookCommand(printStream, biblioteca);
    }

    @Test
    public void shouldPromptUserWithBookTitleToReturnWhenUserIsReturningABook(){
        returnBookCommand.execute();

        verify(printStream).println("Enter title of book you wish to return: ");
    }

    @Test
    public void shouldReturnBookWhenUserIsReturningBook() {
        returnBookCommand.execute();

        verify(biblioteca).returnBook("ABC");
    }

}