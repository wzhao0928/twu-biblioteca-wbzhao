package com.twu.biblioteca;

import com.twu.biblioteca.repo.BookListService;
import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.ui.WelcomeMessage;

public class BibliotecaApp {

    private static WelcomeMessage welcomeMessage;
    private static BookListService bookListService;

    public static void main(String[] args) {
        setupComponents();

        System.out.println(welcomeMessage.getWelcomeMessage());
        System.out.println("Book List:");
        bookListService.print();

    }

    private static void setupComponents() {
        welcomeMessage = new WelcomeMessage();
        bookListService = new PreExistingBookListSize5();
    }
}
