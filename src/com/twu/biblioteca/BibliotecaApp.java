package com.twu.biblioteca;

import com.twu.biblioteca.logic.CommandProcessor;
import com.twu.biblioteca.repo.ItemListService;
import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.repo.PreExistingMovieListSize3;
import com.twu.biblioteca.ui.*;

public class BibliotecaApp {

    private static WelcomeMessage welcomeMessage;
    private static Console console;

    public static void main(String[] args) {
        setupComponents();
        System.out.println(welcomeMessage.getWelcomeMessage());
        String terminationMsg = console.run();
        System.out.println(terminationMsg);
    }

    private static void setupComponents() {
        welcomeMessage = new WelcomeMessage();
        ItemListService bookListService = new PreExistingBookListSize5();
        ItemListService movieListService = new PreExistingMovieListSize3();
//        Console.MainMenu mainMenu = new Console.MainMenu();
        CommandProcessor processor = new CommandProcessor(bookListService, movieListService);
        console = new Console(processor);
    }
}

