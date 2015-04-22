package com.twu.biblioteca;

import com.twu.biblioteca.ui.Console;
import com.twu.biblioteca.ui.WelcomeMessage;

public class BibliotecaApp {

    private static WelcomeMessage welcomeMessage;
    private static Console console;

    public static void main(String[] args) {
        setupComponents();
        console.run();
    }

    private static void setupComponents() {
        welcomeMessage = new WelcomeMessage();
        console = new Console();
        console.init();
    }
}

