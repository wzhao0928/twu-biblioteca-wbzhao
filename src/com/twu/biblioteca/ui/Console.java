package com.twu.biblioteca.ui;

/**
 * Created by wbzhao on 15/4/16.
 */
public class Console {
//    private static Session session;
//
//    public Console() {
//        session = new Session();
//    }
//
//    public void setupEnv(OptionExecutor executor) {
//        Option.setupOptionEnv(executor);
//    }
//
//    public String run() {
//        listOptions();
//        Option inputOpt = readCommand();
//        while (!inputOpt.equals(Option.QUIT)) {
//            response(inputOpt);
//            listOptions();
//            inputOpt = readCommand();
//        }
//        return "Bye Bye!";
//    }
//
//    public Session getSession() {
//        return session;
//    }
//
//    public Option[] listOptions() {
//        showOptionList(session.isLoggedIn());
//        return Option.getOptions(session.isLoggedIn());
//    }
//
//    public Option readCommand() {
//        String inputString = new Scanner(System.in).nextLine();
//        for (Option option : Option.getOptions(session.isLoggedIn())) {
//            if (!option.equals(Option.INVALID) && inputString.equals(option.toString()))
//                return option;
//        }
//        return Option.INVALID;
//    }
//
//    public String response(Option option) {
//        String responseMsg = option.execute();
//        System.out.println();
//        System.out.println(responseMsg);
//        System.out.println();
//        return responseMsg;
//    }
//
//    public String[] collectLoginInfo() {
//        String[] libNumberAndPsw = new String[2];
//        System.out.print("\tPlease input your Library number: ");
//        libNumberAndPsw[0] = new Scanner(System.in).nextLine();
//        System.out.print("\tYour password: ");
//        libNumberAndPsw[1] = new Scanner(System.in).nextLine();
//        return libNumberAndPsw;
//    }
//
//    private static void showOptionList(boolean isLoggedIn) {
//        Option[] options = Option.getOptions(isLoggedIn);
//        System.out.print("Available Options:\r\n\t");
//        for (Option opt : options) {
//            if (!opt.equals(Option.INVALID))
//                System.out.print("[" + opt.toString() + "] ");
//        }
//        System.out.print("\r\n");
//        System.out.print("Input Your Option > ");
//    }

    public void printMessage(ConsoleMessage message) {
        System.out.println(message.getContent());
    }

    public void printMainMenue(MainMenu menu) {
        System.out.print("Available Options:\r\n" +
                "\t[List Books] [List Movies] [Quit] [Log In]\r\n" +
                "Input Your Option > ");
    }

    public void init() {


    }

    public void run() {
        printMessage(new WelcomeMessage());
        printMainMenue(new MainMenu());
    }
}
