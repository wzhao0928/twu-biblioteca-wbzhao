package com.twu.biblioteca.ui;

import com.twu.biblioteca.logic.CommandProcessor;

/**
 * Created by wbzhao on 15-4-12.
 */
public enum Option {
    LIST_BOOKS("List Books") {
        @Override
        public String execute() {
            return processor.doListBooks();
        }
    },

    INVALID(null) {
        @Override
        public String execute() {
            return "Select a valid option!";
        }
    },

    QUIT("Quit") {
        @Override
        public String execute() {
            return "";
        }
    },

    CHECKOUT("Check-out Book") {
        @Override
        public String execute() {
            return processor.doCheckOut();
        }
    },

    RETURN("Return Book") {
        @Override
        public String execute() {
            return processor.doReturn();
        }
    };

    private String optString;
    private static CommandProcessor processor;

    Option(String optString) {
        this.optString = optString;
    }

    public static void setProcessor(CommandProcessor processor) {
        Option.processor = processor;
    }

    @Override
    public String toString() {
        return optString;
    }

    abstract public String execute();
}
