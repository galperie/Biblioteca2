package com.twu.biblioteca;

/**
 * Created by jmann on 6/19/15.
 */
public class ListBooksCommand implements Command {
    private Biblioteca biblioteca;

    public ListBooksCommand(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.listBooks();
    }
}
