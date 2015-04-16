package com.twu.biblioteca.ui;

import com.twu.biblioteca.logic.CommandProcessor;
import com.twu.biblioteca.logic.Option;

import java.util.Scanner;

/**
 * Created by wbzhao on 15/4/16.
 */
public class Console {
    private CommandProcessor processor;
    private Boolean isLoggedIn = false;

    public CommandProcessor getProcessor() {
        return processor;
    }

    public Console(CommandProcessor processor) {
        this.processor = processor;
        Option.setConsole(this);
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String run() {
        listOptions();
        Option inputOpt = readCommand();
        while (!inputOpt.equals(Option.QUIT)) {
            processor.response(inputOpt);
            listOptions();
            inputOpt = readCommand();
        }
        return "Bye Bye!";
    }

    public Option[] listOptions() {
        showOptionList(isLoggedIn);
        return Option.getOptions(isLoggedIn);
    }

    private static void showOptionList(boolean isLoggedIn) {
        Option[] options = Option.getOptions(isLoggedIn);
        System.out.print("Available Options:\r\n\t");
        for (Option opt : options) {
            if (!opt.equals(Option.INVALID))
                System.out.print("[" + opt.toString() + "] ");
        }
        System.out.print("\r\n");
        System.out.print("Input Your Option > ");
    }

    public Option readCommand() {
        String inputString = new Scanner(System.in).nextLine();
        for (Option option : Option.getOptions(isLoggedIn)) {
            if (!option.equals(Option.INVALID) && inputString.equals(option.toString()))
                return option;
        }
        return Option.INVALID;
    }

}
