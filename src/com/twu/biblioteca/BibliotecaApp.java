package com.twu.biblioteca;

import com.twu.biblioteca.logic.CommandProcessor;
import com.twu.biblioteca.repo.BookListService;
import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.ui.CommandLine;
import com.twu.biblioteca.ui.MainMenu;
import com.twu.biblioteca.ui.Option;
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
        mainMenu.listOptions();
        Option inputOpt = commandLine.readCommand();
        while (!inputOpt.equals(Option.QUIT)) {
            processor.response(inputOpt);
            mainMenu.listOptions();
            inputOpt = commandLine.readCommand();
        }

        System.out.println("Bye Bye!");
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
