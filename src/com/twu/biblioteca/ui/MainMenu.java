package com.twu.biblioteca.ui;

/**
 * Created by wbzhao on 15-4-12.
 */
public class MainMenu {

    public Option[] listOptions() {
        showOptionList();
        return Option.values();
    }

    private void showOptionList() {
        Option[] options = Option.values();
        System.out.print("Available Options:\r\n\t");
        for (Option opt : options) {
            if (!opt.equals(Option.INVALID))
                System.out.print("[" + opt.toString() + "] ");
        }
        System.out.print("\r\n");
        System.out.print("Input Your Option > ");
    }
}
