package com.monprojet.web;


import com.monprojet.jdbc.Database;


public class AuthService {

    private Database database;
    
    public AuthService(Database database) {
        this.database = database;
    }

    public boolean authenticate(String username, String password) {
        System.out.println(username +" " + password);

        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        String[][] result = database.executeQuery(query);

        if (result != null && result.length > 1) {
            return true;
        }
        return false;
    }
}
