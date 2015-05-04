package com.twu.biblioteca;

import com.twu.biblioteca.ui.Console;
import com.twu.biblioteca.ui.MessageFactory;

public class BibliotecaApp {

    private static Console console;

    public static void main(String[] args) {
        setUpBibliotecaComponents();
        System.out.println();
        console.run();
    }

    private static void setUpBibliotecaComponents() {
        console = new Console(new MessageFactory());
        console.init();
    }

}

