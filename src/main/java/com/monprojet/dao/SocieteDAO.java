package com.monprojet.dao;

import com.monprojet.models.Societe;
import java.util.List;

public interface SocieteDAO {
    // Method to add a new company
    void ajouterSociete(Societe societe);
    
    // Method to find a company by its ID
    Societe trouverSocieteParId(int id);
    
    // Method to list all companies
    List<Societe> listerSocietes();
    
    // Method to delete a company by its ID
    void supprimerSociete(int id);
    
    // Method to check if a company already exists (to prevent duplicates)
    boolean verifierDoublon(Societe societe);
}
