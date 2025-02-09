package com.monprojet.models;

import java.util.Date;

public class OffresNavettes {
private int id ;
private int entp_id;
private Date date_debut;
private Date date_fin;
private String ville_depart;
private String ville_arrive;
private String heure_depart;
private String heure_arrive;
private int abonnés_cibles;
private int abonnés_actuels;
private String description;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getEntp_id() {
	return entp_id;
}
public void setEntp_id(int entp_id) {
	this.entp_id = entp_id;
}
public Date getDate_debut() {
	return date_debut;
}
public void setDate_debut(Date date_debut) {
	this.date_debut = date_debut;
}
public Date getDate_fin() {
	return date_fin;
}
public void setDate_fin(Date date_fin) {
	this.date_fin = date_fin;
}
public String getVille_depart() {
	return ville_depart;
}
public void setVille_depart(String ville_depart) {
	this.ville_depart = ville_depart;
}
public String getVille_arrive() {
	return ville_arrive;
}
public void setVille_arrive(String ville_arrive) {
	this.ville_arrive = ville_arrive;
}
public String getHeure_depart() {
	return heure_depart;
}
public void setHeure_depart(String heure_depart) {
	this.heure_depart = heure_depart;
}
public String getHeure_arrive() {
	return heure_arrive;
}
public void setHeure_arrive(String heure_arrive) {
	this.heure_arrive = heure_arrive;
}
public int getAbonnés_cibles() {
	return abonnés_cibles;
}
public void setAbonnés_cibles(int abonnés_cibles) {
	this.abonnés_cibles = abonnés_cibles;
}
public int getAbonnés_actuels() {
	return abonnés_actuels;
}
public void setAbonnés_actuels(int abonnés_actuels) {
	this.abonnés_actuels = abonnés_actuels;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
