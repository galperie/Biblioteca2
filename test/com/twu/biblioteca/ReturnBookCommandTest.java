package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by jmann on 6/22/15.
 */
public class ReturnBookCommandTest {

    @Test
    public void shouldPromptUserWithBookTitleToReturnWhenUserIsReturningABook(){
        PrintStream printStream = mock(PrintStream.class);
        Command returnBookCommand = new ReturnBookCommand(printStream);

        returnBookCommand.execute();

        verify(printStream).println("Enter title of book you wish to return: ");
    }
}