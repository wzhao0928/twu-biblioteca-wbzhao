package com.twu.biblioteca.logic;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;

import java.util.ArrayList;

/**
 * Created by wbzhao on 15/4/16.
 */
public enum Option {
    LIST_BOOKS("List Books", Type.COMMON) {
        @Override
        public String execute() {
            return executor.doListItems(Book.class);
        }
    },

    LIST_MOVIES("List Movies", Type.COMMON) {
        @Override
        public String execute() {
            return executor.doListItems(Movie.class);
        }
    },

    INVALID(null, Type.COMMON) {
        @Override
        public String execute() {
            return "Select a valid option!";
        }
    },

    QUIT("Quit", Type.COMMON) {
        @Override
        public String execute() {
            return "";
        }
    },

    CHECKOUT_BOOK("Check-out Book", Type.AFTER_LOGIN) {
        @Override
        public String execute() {
            return executor.doCheckOut(Book.class);
        }
    },

    RETURN_BOOK("Return Book", Type.AFTER_LOGIN) {
        @Override
        public String execute() {
            return executor.doReturn(Book.class);
        }
    },

    CHECKOUT_MOVIE("Check-out Movie", Type.AFTER_LOGIN) {
        @Override
        public String execute() {
            return executor.doCheckOut(Movie.class);
        }
    },

    RETURN_MOVIE("Return Movie", Type.AFTER_LOGIN) {
        @Override
        public String execute() {
            return executor.doReturn(Movie.class);
        }
    },

    LOG_IN("Log in", Type.BEFORE_LOGIN) {
        @Override
        public String execute() {
            return executor.doLogIn(executor.getConsole().collectLoginInfo());
        }
    },

    LOG_OUT("Log out", Type.AFTER_LOGIN) {
        @Override
        public String execute() {
            return executor.doLogOut();
        }
    }
    ;

    private String optString;
//    private static Console console;
    private static OptionExecutor executor;
    private final Type type;

    public enum Type {COMMON, BEFORE_LOGIN, AFTER_LOGIN}

    Option(String optString, Type type) {
        this.optString = optString;
        this.type = type;
    }

    public static void setupOptionEnv(OptionExecutor exec) {
//        console = consl;
        executor = exec;
    }

    public static com.twu.biblioteca.logic.Option[] getOptions(boolean isLoggedIn) {
        com.twu.biblioteca.logic.Option[] allOptions = com.twu.biblioteca.logic.Option.values();
        ArrayList<com.twu.biblioteca.logic.Option> availableOptList = new ArrayList<com.twu.biblioteca.logic.Option>();
        for (com.twu.biblioteca.logic.Option option : allOptions) {
            switch (option.type) {
                case COMMON:
                    availableOptList.add(option); break;
                case BEFORE_LOGIN:
                    if (!isLoggedIn) availableOptList.add(option); break;
                case AFTER_LOGIN:
                    if (isLoggedIn) availableOptList.add(option); break;
                default:
                    break;
            }
        }
        return availableOptList.toArray(new com.twu.biblioteca.logic.Option[]{});
    };

    @Override
    public String toString() {
        return optString;
    }

    abstract public String execute();
}

