package com.monprojet.web;

import com.monprojet.dao.NavetteDAO;
import com.monprojet.dao.Navetteimpl;
import com.monprojet.jdbc.Database;
import com.monprojet.models.Navette;
import java.util.List;

public class NavetteController {
    private NavetteDAO navetteDAO;

    public NavetteController(Database database) {
        this.navetteDAO = new Navetteimpl(database);
    }

    // Ajouter une navette
    public void ajouterNavette(int id, String villeDepart, String villeArrivee, String heureDepart, String heureArrivee, String description) {
        Navette navette = new Navette(id, villeDepart, villeArrivee, heureDepart, heureArrivee, description);
        navetteDAO.ajouterNavette(navette);
    }

    // Trouver une navette par son ID
    public Navette trouverNavetteParId(int id) {
        return navetteDAO.trouverNavetteParId(id);
    }

    // Lister toutes les navettes
    public List<Navette> listerNavettes() {
        return navetteDAO.listerNavettes();
    }

    // Supprimer une navette par son ID
    public void supprimerNavette(int id) {
        navetteDAO.supprimerNavette(id);
    }

    // Vérifier si une navette existe déjà
    public boolean verifierDoublon(Navette navette) {
        return navetteDAO.verifierDoublon(navette);
    }
}
