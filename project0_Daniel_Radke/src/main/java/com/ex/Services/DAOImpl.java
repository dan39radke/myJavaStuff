package com.ex.Services;

import com.ex.db.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DAOImpl implements DAO{

  private DBConnectionUtil dbConnecter;

  public DAOImpl(DBConnectionUtil dbConnecter){
      this.dbConnecter = dbConnecter;
  }

    @Override
    public Map<String,String> getCredentials() {
        Connection c = null;
        Map<String,String> credentials = new HashMap<String, String>();
        try {
            c = dbConnecter.getConnection();
            String stmt = "Select usernamesandpasswords.username, usernamesandpasswords.password " +
                    "from usernamesandpasswords";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(stmt);

            while(rs.next()) {
                credentials.put(rs.getString("username"),rs.getString("password"));
            } return credentials;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getOpenCreditAccounts(String username) {
        Connection c = null;
        List<String> creditAccounts = new ArrayList<String>();
        try{
            c = dbConnecter.getConnection();
            String stmt = "Select usercreditaccounts.creditcard, usercreditaccounts.accountnumber " +
                    "from usercreditaccounts where usercreditaccounts.username = ?";
            PreparedStatement ps = c.prepareStatement(stmt);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                creditAccounts.add(rs.getString("creditcard"));
                creditAccounts.add(rs.getString("accountnumber"));
            } return creditAccounts;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getOpenLoansAccounts(String username) {
        Connection c = null;
        List<String> loanAccounts = new ArrayList<String>();
        try{
            c = dbConnecter.getConnection();
            String stmt = "Select loantype, bank, " +
                    "accountnumber from userloanaccounts where username = ?";
            PreparedStatement ps = c.prepareStatement(stmt);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                loanAccounts.add(rs.getString("loantype"));
                loanAccounts.add(rs.getString("bank"));
                loanAccounts.add(rs.getString("accountnumber"));
            } return loanAccounts;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCreditScore(String username) {
        Connection c = null;
        int creditScore = 0;
        try{
            c = dbConnecter.getConnection();
            String stmt = "Select userworthiness.creditscore from userworthiness where userworthiness.username = ?";
            PreparedStatement ps = c.prepareStatement(stmt);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                creditScore = rs.getInt("creditscore");
            } return creditScore;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<String> getRecommendedCreditCards(int creditScore) {
        Connection c = null;
        List<String> recommendedCreditCards = new ArrayList<String>();
        String creditScoreDesc;
        String recommendedIncome = "";

        if(creditScore>720) {
            creditScoreDesc = "Excellent";
        }else if(creditScore<=720 && creditScore>=690) {
            creditScoreDesc = "Good";
        }else if(creditScore<=689 && creditScore>630) {
            creditScoreDesc = "Average";
        }else {
            creditScoreDesc = "Bad";
        }
        try{
            c = dbConnecter.getConnection();
            String stmt = "Select recommendedcreditcards.creditcard, recommendedcreditcards.income " +
                    "from recommendedcreditcards where recommendedcreditcards.creditscoredesc = ?";
            PreparedStatement ps = c.prepareStatement(stmt);
            ps.setString(1,creditScoreDesc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                recommendedCreditCards.add(rs.getString("creditcard"));
                recommendedIncome = rs.getString("income");
            } return recommendedCreditCards;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateIncome(String username, int income) {
        Connection c = null;
        String strIncome = Integer.toString(income);
        int rowsUpdated;
        try {
            c = dbConnecter.getConnection();
            String sql = "Update userworthiness set income = " + strIncome +
                    " where username = " + "'" + username + "'";
            Statement stmt = c.createStatement();
            rowsUpdated = stmt.executeUpdate(sql);
            return rowsUpdated;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }


    @Override
    public List<String> getCreditPaymentInfo(String username, String creditCard) {
        Connection c = null;
        List<String> creditPaymentInfo = new ArrayList<String>();
        try{
            c = dbConnecter.getConnection();
            String stmt = "Select usercreditaccounts.balance, usercreditaccounts.lastpayment, " +
                    "usercreditaccounts.duedate, usercreditaccounts.hasdefault " +
                    "from usercreditaccounts where usercreditaccounts.username = ? and usercreditaccounts.creditcard = ?";
            PreparedStatement ps = c.prepareStatement(stmt);
            ps.setString(1,username);
            ps.setString(2,creditCard);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                creditPaymentInfo.add(rs.getString("balance"));
                creditPaymentInfo.add(rs.getString("lastpayment"));
                creditPaymentInfo.add(rs.getString("duedate"));
                creditPaymentInfo.add(rs.getString("hasdefault"));
            } return creditPaymentInfo;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       return null;
    }

    @Override
    public int getIncome(String username) {
        Connection c = null;
        int income = 0;
        try{
            c = dbConnecter.getConnection();
            String stmt = "Select income from userworthiness where username = ?";
            PreparedStatement ps = c.prepareStatement(stmt);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               income = rs.getInt("income");
            } return income;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<String> getLoanPaymentInfo(long accountNumber) {
        Connection c = null;
        List<String> loanPaymentInfo = new ArrayList<String>();
        try{
            c = dbConnecter.getConnection();
            String stmt = "Select userloanaccounts.balance, userloanaccounts.lastpayment, " +
                    "userloanaccounts.duedate, userloanaccounts.hasdefault " +
                    "from userloanaccounts where userloanaccounts.accountnumber = ?";
            PreparedStatement ps = c.prepareStatement(stmt);
            ps.setLong(1,accountNumber);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                loanPaymentInfo.add((rs.getString("balance") + " " +rs.getString("lastpayment") +
                        " " + rs.getString("duedate") + " " + rs.getString("hasdefault")));
            } return loanPaymentInfo;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       return null;
    }

    @Override
    public int addUser(String username, String password) {
        Connection c = null;
        int rowsUpdated;
        try{
            c = dbConnecter.getConnection();
            String stmt1 = "Insert into usernamesandpasswords (username, password) Values ("
                    + username + "," + password + ")";
            Statement stmt = c.createStatement();
            rowsUpdated = stmt.executeUpdate(stmt1);
            System.out.println("Welcome new user!");
            return rowsUpdated;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return -1;
    }
}
