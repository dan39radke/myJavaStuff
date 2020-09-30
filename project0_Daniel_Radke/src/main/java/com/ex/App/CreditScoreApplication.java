package com.ex.App;

import com.ex.Accounts.User;

import java.util.Scanner;

public class CreditScoreApplication extends Application {

    private User user;
    private Login login;
    private Welcome welcome;
    private Screen currentScreen = null;
    private Scanner scanner;

    public CreditScoreApplication() {
        this.user = user;
        this.login = login;
        this.welcome = welcome;
        currentScreen = new Login();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while(currentScreen!=null) {
            currentScreen = currentScreen.appScreen(this);
        }
    }

    public User getUser() { return user; }

    public Login getLogin() { return login; }

    public Welcome getWelcome() { return welcome; }

    public Screen getCurrentScreen() { return currentScreen; }

    public Scanner getScanner() { return scanner; }
}
