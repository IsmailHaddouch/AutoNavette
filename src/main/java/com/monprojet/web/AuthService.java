package com.monprojet.web;


import com.monprojet.jdbc.Database;


public class AuthService {

    private Database database;
    
    public AuthService(Database database) {
        this.database = database;
    }

    public boolean authenticate(String email, String motDePasse) {
        System.out.println(email +" " + motDePasse);

        String query = "SELECT * FROM utilisateur WHERE email = '" + email + "' AND motDePasse = '" + motDePasse + "'";
        String[][] result = database.ExecuteQuery(query);

        if (result != null && result.length > 1) {
            return true;
        }
        return false;
    }
}
