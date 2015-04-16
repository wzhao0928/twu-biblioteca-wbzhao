package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.logic.CommandProcessor;

import java.util.ArrayList;

/**
 * Created by wbzhao on 15-4-12.
 */
public enum Option {
    LIST_BOOKS("List Books", Type.COMMON) {
        @Override
        public String execute() {
            return processor.doListBooks();
        }
    },

    LIST_MOVIES("List Movies", Type.COMMON) {
        @Override
        public String execute() {
            return processor.doListMovies();
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
            return processor.doCheckOut(Book.class);
        }
    },

    RETURN_BOOK("Return Book", Type.AFTER_LOGIN) {
        @Override
        public String execute() {
            return processor.doReturn(Book.class);
        }
    },

    CHECKOUT_MOVIE("Check-out Movie", Type.AFTER_LOGIN) {
        @Override
        public String execute() {
            return processor.doCheckOut(Movie.class);
        }
    },

    RETURN_MOVIE("Return Movie", Type.AFTER_LOGIN) {
        @Override
        public String execute() {
            return processor.doReturn(Movie.class);
        }
    },

    LOG_IN("Log in", Type.BEFORE_LOGIN) {
        @Override
        public String execute() {
            return null;
        }
    },

    LOG_OUT("Log out", Type.AFTER_LOGIN) {
        @Override
        public String execute() {
            return null;
        }
    }
    ;

    private String optString;
    private static CommandProcessor processor;
    private final Type type;

    public enum Type {COMMON, BEFORE_LOGIN, AFTER_LOGIN}

    Option(String optString, Type type) {
        this.optString = optString;
        this.type = type;
    }

    public static void setProcessor(CommandProcessor processor) {
        Option.processor = processor;
    }

    public static Option[] getOptions(boolean isLoggedIn) {
        Option[] allOptions = Option.values();
        ArrayList<Option> availableOptList = new ArrayList<Option>();
        for (Option option : allOptions) {
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
        return availableOptList.toArray(new Option[]{});
    };

    @Override
    public String toString() {
        return optString;
    }

    abstract public String execute();
}