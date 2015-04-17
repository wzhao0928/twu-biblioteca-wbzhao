package com.twu.biblioteca.ui;

import com.twu.biblioteca.authentication.Session;
import com.twu.biblioteca.logic.Option;
import com.twu.biblioteca.logic.OptionExecutor;

import java.util.Scanner;

/**
 * Created by wbzhao on 15/4/16.
 */
public class Console {
    private static Session session;

    public Console() {
        session = new Session();
    }

    public void setupEnv(OptionExecutor executor) {
        Option.setupOptionEnv(executor);
    }

    public String run() {
        listOptions();
        Option inputOpt = readCommand();
        while (!inputOpt.equals(Option.QUIT)) {
            response(inputOpt);
            listOptions();
            inputOpt = readCommand();
        }
        return "Bye Bye!";
    }

    public Session getSession() {
        return session;
    }

    public Option[] listOptions() {
        showOptionList(session.isLoggedIn());
        return Option.getOptions(session.isLoggedIn());
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
        for (Option option : Option.getOptions(session.isLoggedIn())) {
            if (!option.equals(Option.INVALID) && inputString.equals(option.toString()))
                return option;
        }
        return Option.INVALID;
    }

    public String response(Option option) {
        String responseMsg = option.execute();
        System.out.println();
        System.out.println(responseMsg);
        System.out.println();
        return responseMsg;
    }

}
