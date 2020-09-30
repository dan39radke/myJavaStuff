package com.ex.Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIOdao {

    public boolean verifyCredentialsFileIO(String username, String password) {
        String credential = username + "," + password;
        FileReader read = null;
        String line = null;
        ArrayList<String> loginCredentials = new ArrayList<String>();

        try {
            read = new FileReader("C:\\Users\\radke\\Documents\\2007_jul13_java_august\\Daniel_Radke_Code\\" +
                    "Week1_Java\\project0_Daniel_Radke\\Data\\usernamesAndPasswords.csv");
            BufferedReader reader = new BufferedReader(read);
            while((line = reader.readLine()) != null) {
                loginCredentials.add(line);
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
        if(loginCredentials.contains(credential)) {
            return true;
        }else {
            return false;
        }
    }

}
