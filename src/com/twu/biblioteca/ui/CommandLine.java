package com.twu.biblioteca.ui;

import java.util.Scanner;

/**
 * Created by wbzhao on 15-4-12.
 */
public class CommandLine {
    public Option readCommand() {
        System.out.print("Input Your Option > ");
        String inputString = new Scanner(System.in).nextLine();
        for (Option option : Option.values()) {
            if (inputString.startsWith(option.toString()))
                return option;
        }
        return null;
    }
}
