package com.ex.Accounts;

import com.ex.Services.DAO;
import com.ex.Services.DAOImpl;
import com.ex.db.JDBCConnect;

import java.util.List;

public class User {

    private String username;
    private String password;
    private int creditScore;
    private int income;
    private List<String> recommendedCreditCards;
    private List<String> openCreditAccounts;
    private List<String> openLoanAccounts;

    DAO appDAO = new DAOImpl(JDBCConnect.connect());
    // JDBCConnect jdbc = new JDBCConnect(appDAO);

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.creditScore = appDAO.getCreditScore(username);
        this.income = appDAO.getIncome(username);
        this.recommendedCreditCards = appDAO.getRecommendedCreditCards(creditScore);
        this.openCreditAccounts = appDAO.getOpenCreditAccounts(username);
        this.openLoanAccounts = appDAO.getOpenLoansAccounts(username);
    }


    public boolean verifyCredentials() {
        if(appDAO.getCredentials().containsKey(username)) {
            if(appDAO.getCredentials().get(username).equals(password)) {
                return true;
            }
        } return false;
    }

    public void updateIcome(String username, int income) {
        int rowsUpdated = appDAO.updateIncome(username,income);
        System.out.println("You updated " + rowsUpdated + " rows.");
    }

    public List<String> creditPaymentInfo(String username, String creditCard) {
        List<String> creditPaymentInfo = appDAO.getCreditPaymentInfo(username,creditCard);
        return creditPaymentInfo;
    }

    public List<String> loanPaymentInfo(long accountNumber) {
        List<String> loanPaymentInfo = appDAO.getLoanPaymentInfo(accountNumber);
        return loanPaymentInfo;
    }

    public int getCreditScore() { return creditScore; }
    public List<String> getRecommendedCreditCards() { return recommendedCreditCards; }
    public List<String> getOpenCreditAccounts() { return openCreditAccounts; }
    public List<String> getOpenLoanAccounts() { return openLoanAccounts; }
    public String getUsername() { return username; }

    public void logout() {
        System.out.println("You have been logged out");
    }

}
