package com.ex.Services;

import java.util.List;
import java.util.Map;

public interface DAO {

    Map<String,String> getCredentials();
    List<String> getOpenCreditAccounts(String username);
    List<String> getOpenLoansAccounts(String username);
    int getCreditScore(String username);
    List<String> getRecommendedCreditCards(int creditScore);
    List<String> getCreditPaymentInfo(String username, String creditCard);
    List<String> getLoanPaymentInfo(long accountNumber);
    int getIncome(String username);

    int updateIncome(String username, int income);
    int addUser(String username, String password);

}
