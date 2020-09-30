package com.ex.App;

import com.ex.Accounts.User;

import java.util.Scanner;

public class NewUser implements Screen {

    User newUser;

    @Override
    public Screen appScreen(Application app) {
        Scanner scanner = ((CreditScoreApplication)app).getScanner();
        System.out.println("Hello new user");
        System.out.println("Enter a username and password");
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        newUser = new User(username,password);
        System.out.println("You are being redirected to the login screen");
        System.out.println("____________________________________________");
        return new Login();
    }
}
