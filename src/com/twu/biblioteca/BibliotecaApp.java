package com.twu.biblioteca;

import com.twu.biblioteca.logic.CommandProcessor;
import com.twu.biblioteca.repo.BookListService;
import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.ui.CommandLine;
import com.twu.biblioteca.ui.MainMenu;
import com.twu.biblioteca.ui.WelcomeMessage;

public class BibliotecaApp {

    private static WelcomeMessage welcomeMessage;
    private static BookListService bookListService;
    private static MainMenu mainMenu;
    private static CommandLine commandLine;
    private static CommandProcessor processor;

    public static void main(String[] args) {
        setupComponents();

        System.out.println(welcomeMessage.getWelcomeMessage());
//        System.out.println("Book List:");
//        bookListService.print();
        mainMenu.listOptions();
//        commandLine.readCommand();
        processor.response(commandLine.readCommand());

    }

    private static void setupComponents() {
        welcomeMessage = new WelcomeMessage();
        bookListService = new PreExistingBookListSize5();
        mainMenu = new MainMenu();
        commandLine = new CommandLine();
        processor = new CommandProcessor(bookListService);
    }
}

// TODO: main menu
