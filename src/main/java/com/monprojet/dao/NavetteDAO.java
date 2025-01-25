package com.monprojet.dao;

import com.monprojet.models.Navette;
import java.util.List;

public interface NavetteDAO {
    // Méthode pour ajouter une nouvelle navette
    void ajouterNavette(Navette navette);
    
    // Méthode pour trouver une navette par son ID
    Navette trouverNavetteParId(int id);
    
    // Méthode pour lister toutes les navettes
    List<Navette> listerNavettes();
    
    // Méthode pour supprimer une navette par son ID
    void supprimerNavette(int id);
    
    // Méthode pour vérifier si une navette avec les mêmes données existe déjà (pour éviter les doublons)
    boolean verifierDoublon(Navette navette);
}
