package com.ex.App;

import com.ex.Accounts.User;
import com.ex.Services.DAO;
import com.ex.Services.DAOImpl;
import com.ex.db.JDBCConnect;
import com.ex.db.PGDBConnectionUtil;

import java.util.Scanner;

public class Login implements Screen {
    /***
     * This is the opening login screen.
     * Your username and password input is sent to the LoginCredentials class to verify
     * whether your credentials match, a true or false will return.
     * This class can easily be implemented with a JDBC, you just need to switch the class that verifies your
     * credentials.
     */

    public Screen appScreen(Application app) {

        DAO appDAO = new DAOImpl(JDBCConnect.connect());
        JDBCConnect jdbc = new JDBCConnect(appDAO);
        Scanner scanner = ((CreditScoreApplication) app).getScanner();
        User user;

        System.out.println("Hello, this application is built to check your credit score, view and manage credit accounts, " +
                "and view your credit history.");
        System.out.println("Select an option");
        System.out.println("1: Login");
        System.out.println("2: New User");
        int decision = scanner.nextInt();

        switch (decision) {
            case 1:
                System.out.println("Please login by entering your username and password.");
                System.out.print("Username: ");
                String username = scanner.next();
                System.out.print("Password: ");
                String password = scanner.next();
                user = new User(username,password);

                while (!user.verifyCredentials()) {
                    System.out.println("Your login credentials were incorrect. Try again.");
                    System.out.print("Username: ");
                    String username1 = scanner.next();
                    System.out.print("Password: ");
                    String password1 = scanner.next();
                    user = new User(username1,password1);
                }
                if (user.verifyCredentials()) {
                    System.out.println();
                    return new Welcome(user);
                }
            case 2:
                return new NewUser();
        }
        return null;
    }
}
