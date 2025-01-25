package com.monprojet.models;

public class Demande {
    private int id;
    private String villeDepart;
    private String villeArrivee;
    private String periodeDebut;
    private String periodeFin;
    private String heureDepart;
    private String heureArrivee;
    private int nbInteresses;

    // Constructeur
    public Demande() {
		// TODO Auto-generated constructor stub
	}
    
    
    public Demande(int id, String villeDepart, String villeArrivee, String periodeDebut, String periodeFin, String heureDepart, String heureArrivee, int nbInteresses) {
        this.id = id;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.periodeDebut = periodeDebut;
        this.periodeFin = periodeFin;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.nbInteresses = nbInteresses;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public String getPeriodeDebut() {
        return periodeDebut;
    }

    public void setPeriodeDebut(String periodeDebut) {
        this.periodeDebut = periodeDebut;
    }

    public String getPeriodeFin() {
        return periodeFin;
    }

    public void setPeriodeFin(String periodeFin) {
        this.periodeFin = periodeFin;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public int getNbInteresses() {
        return nbInteresses;
    }

    public void setNbInteresses(int nbInteresses) {
        this.nbInteresses = nbInteresses;
    }
}
