package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private Biblioteca biblioteca;
    private MainMenu menu;

    @Before
    public void setup() throws IOException {
        biblioteca = mock(Biblioteca.class);
        menu = mock(MainMenu.class);
        bibliotecaApp = new BibliotecaApp(biblioteca, menu);
    }




    @Test
    public void shouldStartGrabbingMenuOptionsWhenAppStarts() {
        bibliotecaApp.start();

        verify(menu).getUserMenuOption();
    }


}