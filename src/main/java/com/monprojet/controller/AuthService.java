package com.monprojet.controller;


import com.monprojet.jdbc.Database;


public class AuthService {

    private Database database;
    
    public AuthService(Database database) {
        this.database = database;
    }

    public boolean authenticate(String username, String motDePass) {
        System.out.println(username +" " + motDePass);

        String query = "SELECT * FROM utilisateur WHERE username = '" + username + "' AND motDePass = '" + motDePass + "'";
        String[][] result = database.ExecuteQuery(query);

        if (result != null && result.length > 1) {
            return true;
        }
        return false;
    }
}
