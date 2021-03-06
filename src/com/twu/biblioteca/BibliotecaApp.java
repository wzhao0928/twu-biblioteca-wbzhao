package com.twu.biblioteca;

import com.twu.biblioteca.logic.OptionExecutor;
import com.twu.biblioteca.repo.ItemListService;
import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.repo.PreExistingMovieListSize3;
import com.twu.biblioteca.repo.UserListService;
import com.twu.biblioteca.ui.*;

public class BibliotecaApp {

    private static WelcomeMessage welcomeMessage;
    private static Console console;

    public static void main(String[] args) {
        setupComponents();
        System.out.println(welcomeMessage.getContent());
//        String terminationMsg = console.run();
//        System.out.println(terminationMsg);
    }

    private static void setupComponents() {
        welcomeMessage = new WelcomeMessage();
        ItemListService bookListService = new PreExistingBookListSize5();
        ItemListService movieListService = new PreExistingMovieListSize3();
        UserListService userListService = new UserListService();
        console = new Console();
        OptionExecutor executor = new OptionExecutor(bookListService, movieListService, console, userListService);
//        console.setupEnv(executor);
    }
}

