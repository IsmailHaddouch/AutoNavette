package com.monprojet.dao;

import com.monprojet.models.OffreAbonnement;
import java.util.List;

public interface OffreAbonnementDAO {
    // Method to add a new subscription offer
    void ajouterOffreAbonnement(OffreAbonnement offreAbonnement);
    
    // Method to find a subscription offer by its ID
    OffreAbonnement trouverOffreAbonnementParId(int id);
    
    // Method to list all subscription offers
    List<OffreAbonnement> listerOffresAbonnement();
    
    // Method to delete a subscription offer by its ID
    void supprimerOffreAbonnement(int id);
    
    // Method to check if a subscription offer already exists (to prevent duplicates)
    boolean verifierDoublon(OffreAbonnement offreAbonnement);
}
