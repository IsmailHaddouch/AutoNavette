package com.monprojet.models;

public class OffreAbonnement {
    private int id;
    private String dateDebut;
    private String dateFin;
    private int nbAbonnesVoulus;
    private int nbAbonnesAtteints;
    private String statut;

    // Constructeur
    public OffreAbonnement(int id, String dateDebut, String dateFin, int nbAbonnesVoulus, int nbAbonnesAtteints, String statut) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbAbonnesVoulus = nbAbonnesVoulus;
        this.nbAbonnesAtteints = nbAbonnesAtteints;
        this.statut = statut;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbAbonnesVoulus() {
        return nbAbonnesVoulus;
    }

    public void setNbAbonnesVoulus(int nbAbonnesVoulus) {
        this.nbAbonnesVoulus = nbAbonnesVoulus;
    }

    public int getNbAbonnesAtteints() {
        return nbAbonnesAtteints;
    }

    public void setNbAbonnesAtteints(int nbAbonnesAtteints) {
        this.nbAbonnesAtteints = nbAbonnesAtteints;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
