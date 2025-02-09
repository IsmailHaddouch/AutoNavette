package com.monprojet.models;
import java.util.Date;
public class OffreNavette {
    private int id;
    private int entp_id;
    private Date dateDebut;
    private Date dateFin;
    private String ville_depart;
    private String ville_arrive;
    private String heure_depart;
    private String heure_arrive;
    private int abonnes_cibles;
    private int abonnes_actuels;
    private String description;


    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }


	public int getAbonnes_actuels() {
		return abonnes_actuels;
	}

	public void setAbonnes_actuels(int abonnes_actuels) {
		this.abonnes_actuels = abonnes_actuels;
	}

	public int getAbonnes_cibles() {
		return abonnes_cibles;
	}

	public void setAbonnes_cibles(int abonnes_cibles) {
		this.abonnes_cibles = abonnes_cibles;
	}

	public String getHeure_arrive() {
		return heure_arrive;
	}

	public void setHeure_arrive(String heure_arrive) {
		this.heure_arrive = heure_arrive;
	}

	public String getHeure_depart() {
		return heure_depart;
	}

	public void setHeure_depart(String heure_depart) {
		this.heure_depart = heure_depart;
	}

	public String getVille_arrive() {
		return ville_arrive;
	}

	public void setVille_arrive(String ville_arrive) {
		this.ville_arrive = ville_arrive;
	}

	public String getVille_depart() {
		return ville_depart;
	}

	public void setVille_depart(String ville_depart) {
		this.ville_depart = ville_depart;
	}

	public int getEntp_id() {
		return entp_id;
	}

	public void setEntp_id(int entp_id) {
		this.entp_id = entp_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
