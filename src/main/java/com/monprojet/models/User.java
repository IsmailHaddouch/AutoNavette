package com.monprojet.models;


public class User {
    private int id;
    private String nom;
    private String email;
    private String motDePasse;
    private String typeUser ;

    // Constructeur
    public User(int id, String nom, String email, String motDePasse, String typeUser) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.typeUser = typeUser;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public String gettypeUser() {
        return typeUser;
    }

    public void settypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
}
