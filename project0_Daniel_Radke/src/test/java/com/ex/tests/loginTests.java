package com.ex.tests;

import com.ex.Services.DAO;
import com.ex.Services.DAOImpl;
import com.ex.Services.FileIOdao;
import com.ex.db.JDBCConnect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class loginTests {

    private FileIOdao fdao = null;
    private DAO appDAO = null;

    @Before public void setup() {
        fdao = new FileIOdao();
        appDAO = new DAOImpl(JDBCConnect.connect());
    }

    @After public void cleanup() {
        fdao = null;
        appDAO = null;
        System.out.println("cleaned up");
    }


    @Test
    public void testVerifyLoginFileIO() {
        assertTrue(fdao.verifyCredentialsFileIO("dan39radke@gmail.com", "thisisdan"));
    }

    @Test
    public void testVerifyLoginDB() {
        Map<String, String> credentials = appDAO.getCredentials();
        assertTrue(credentials.containsKey("dan39radke@gmail.com") &&
            appDAO.getCredentials().get("dan39radke@gmail.com").equals("thisisdan"));
        }
}

