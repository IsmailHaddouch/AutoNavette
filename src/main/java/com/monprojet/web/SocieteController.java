package com.monprojet.web;

import com.monprojet.dao.SocieteDAO;
import com.monprojet.dao.SocieteDAOImpl;
import com.monprojet.jdbc.Database;
import com.monprojet.models.Societe;
import java.util.List;

public class SocieteController {
    private SocieteDAO societeDAO;

    public SocieteController(Database database) {
        this.societeDAO = new SocieteDAOImpl(database);
    }

    // Ajouter une société
    public void ajouterSociete(int id, String nom, String adresse) {
        Societe societe = new Societe(id, nom, adresse);
        societeDAO.ajouterSociete(societe);
    }

    // Trouver une société par son ID
    public Societe trouverSocieteParId(int id) {
        return societeDAO.trouverSocieteParId(id);
    }

    // Lister toutes les sociétés
    public List<Societe> listerSocietes() {
        return societeDAO.listerSocietes();
    }

    // Supprimer une société par son ID
    public void supprimerSociete(int id) {
        societeDAO.supprimerSociete(id);
    }

    // Vérifier si une société existe déjà
    public boolean verifierDoublon(Societe societe) {
        return societeDAO.verifierDoublon(societe);
    }
}
