package com.monprojet.models;


public class User {
    private int id;
    private String username;
    private String motDePass;
    private String typeUser ;


    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public void setMotDePasse(String motDePass) {
        this.motDePass = motDePass;
    }
    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
}
