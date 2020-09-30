package com.ex.App;

import com.ex.Accounts.User;

import java.util.List;
import java.util.Scanner;

public class Welcome implements Screen{

    private User user;

    public Welcome(User user) {
        this.user = user;
    }

    @Override
    public Screen appScreen(Application app) {
        Scanner scanner = ((CreditScoreApplication)app).getScanner();
        System.out.println("_________ Select an option ________");
        System.out.println("1: View Credit Score");
        System.out.println("2: View Open Credit Accounts");
        System.out.println("3: View Open Loan Accounts");
        System.out.println("4: View Credit Card Recommendations");
        System.out.println("5: Logout");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println(user.getCreditScore());
                System.out.println("Would you like to update your income?");
                System.out.println("Press Y for yes, N for no");
                char updateYes = scanner.next().charAt(0);
                switch (updateYes) {
                    case 'Y':
                        System.out.println("Enter your new annual income");
                        int newIncome = scanner.nextInt();
                        user.updateIcome(user.getUsername(), newIncome);
                    case 'N':
                        break;
                }
                System.out.println();
                return new Welcome(user);
            case 2:
                System.out.println("Credit Card; Account Number");
                System.out.println(user.getOpenCreditAccounts());
                System.out.println("Would you like to see your payment information?");
                System.out.println("Press Y for yes, N for no");
                char seeCredit = scanner.next().charAt(0);
                switch (seeCredit) {
                    case 'Y':
                        System.out.println("Enter the credit card name as shown above");
                        scanner.nextLine();
                        String card = scanner.nextLine();
                        List<String> info = user.creditPaymentInfo(user.getUsername(),card);
                        System.out.println("Balance; Last Payment; Due Date; Has Defaulted?");
                        System.out.println(info);
                    case 'N':
                        break;
                }
                System.out.println();
                return new Welcome(user);
            case 3:
                System.out.println("Loan Type; Bank; Account Number");
                System.out.println(user.getOpenLoanAccounts());
                System.out.println("Would you like to see your loan payment information?");
                System.out.println("Press Y for yes, N for no");
                char seeLoan = scanner.next().charAt(0);
                switch (seeLoan) {
                    case 'Y':
                        System.out.println("Enter the account number as shown above");
                        List<String> info = user.loanPaymentInfo(scanner.nextLong());
                        System.out.println("Balance; Last Payment; Due Date; Has Defaulted?");
                        System.out.println(info);
                    case 'N':
                        break;
                }
                System.out.println();
                return new Welcome(user);
            case 4:
                System.out.println(user.getRecommendedCreditCards());
                return new Welcome(user);
            case 5:
                user.logout();
                break;
        }
        return null;
    }

}
