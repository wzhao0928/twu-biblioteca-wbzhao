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
    private static Console console;

    public static void main(String[] args) {
        setupComponents();

        System.out.println(welcomeMessage.getWelcomeMessage());

        String terminationMsg = console.run();

        System.out.println(terminationMsg);
    }

    private static void setupComponents() {
        welcomeMessage = new WelcomeMessage();
        BookListService bookListService = new PreExistingBookListSize5();
        MainMenu mainMenu = new MainMenu();
        CommandLine commandLine = new CommandLine();
        CommandProcessor processor = new CommandProcessor(bookListService);
        console = new Console(bookListService, mainMenu, commandLine, processor);
    }
}

class Console {
    private BookListService bookListService;
    private MainMenu mainMenu;
    private CommandLine commandLine;
    private CommandProcessor processor;

    public Console(BookListService bookListService, MainMenu mainMenu, CommandLine commandLine, CommandProcessor processor) {
        this.bookListService = bookListService;
        this.mainMenu = mainMenu;
        this.commandLine = commandLine;
        this.processor = processor;
    }

    public String run() {
        mainMenu.listOptions();
        Option inputOpt = commandLine.readCommand();
        while (!inputOpt.equals(Option.QUIT)) {
            processor.response(inputOpt);
            mainMenu.listOptions();
            inputOpt = commandLine.readCommand();
        }
        return "Bye Bye!";
    }
}

// TODO: main menu
