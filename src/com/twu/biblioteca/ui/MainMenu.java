package com.twu.biblioteca.ui;

/**
 * Created by wbzhao on 15-4-12.
 */
public class MainMenu {

    private boolean login = false;

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isLogin() {
        return login;
    }

    public Option[] listOptions() {
        showOptionList();
        return Option.getOptions(this.login);
    }

    private void showOptionList() {
        Option[] options = Option.getOptions(this.login);
        System.out.print("Available Options:\r\n\t");
        for (Option opt : options) {
            if (!opt.equals(Option.INVALID))
                System.out.print("[" + opt.toString() + "] ");
        }
        System.out.print("\r\n");
        System.out.print("Input Your Option > ");
    }
}
