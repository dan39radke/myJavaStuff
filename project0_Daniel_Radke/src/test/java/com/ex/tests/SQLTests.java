package com.ex.tests;

import com.ex.Services.DAO;
import com.ex.Services.DAOImpl;
import com.ex.Services.FileIOdao;
import com.ex.db.JDBCConnect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SQLTests {

    private FileIOdao fdao = null;
    private DAO appDAO = null;

    @Before
    public void setup() {
        fdao = new FileIOdao();
        appDAO = new DAOImpl(JDBCConnect.connect());
    }

    @After
    public void cleanup() {
        fdao = null;
        appDAO = null;
        System.out.println("cleaned up");
    }

    @Test
    public void testOpenCreditAccounts() {
        assertNotNull(appDAO.getOpenCreditAccounts("dan39radke@gmail.com")); }

    @Test
    public void testOpenLoanAccounts() {
        assertNotNull(appDAO.getOpenLoansAccounts("dan39radke@gmail.com")); }

    @Test
    public void testViewCreditScore() {
        assertNotNull(appDAO.getCreditScore("dan39radke@gmail.com"));}

    @Test
    public void testViewRecommendedCreditCards() {
        assertNotNull(appDAO.getRecommendedCreditCards(734));}

    @Test
    public void testUpdateIncome() {
        int expected = 1;
        int actual = appDAO.updateIncome("dan39radke@gmail.com", 31000);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCreditCardPaymentInfo() {
        assertNotNull(appDAO.getCreditPaymentInfo("dan39radke@gmail.com","Discover Travel"));
    }

    @Test
    public void testGetLoanPaymentInfo() {
        assertNotNull(appDAO.getLoanPaymentInfo(139000000000L));
    }

    @Test
    public void testAddUser() {
        int expected  = 1;
        int actual = appDAO.addUser("'larry@gmail.com'", "'thisislarry'");
        assertEquals(expected,actual);
    }
}
