package com.monprojet.web;

import com.monprojet.dao.OffreAbonnementDAO;
import com.monprojet.dao.OffreAbonnementDAOImpl;
import com.monprojet.jdbc.Database;
import com.monprojet.models.OffreAbonnement;
import java.util.List;

public class OffreAbonnementController {
    private OffreAbonnementDAO offreAbonnementDAO;

    public OffreAbonnementController(Database database) {
        this.offreAbonnementDAO = new OffreAbonnementDAOImpl(database);
    }

    // Ajouter une offre d'abonnement
    public void ajouterOffreAbonnement(int id, String dateDebut, String dateFin, int nbAbonnesVoulus, int nbAbonnesAtteints, String statut) {
        OffreAbonnement offreAbonnement = new OffreAbonnement(id, dateDebut, dateFin, nbAbonnesVoulus, nbAbonnesAtteints, statut);
        offreAbonnementDAO.ajouterOffreAbonnement(offreAbonnement);
    }

    // Trouver une offre d'abonnement par son ID
    public OffreAbonnement trouverOffreAbonnementParId(int id) {
        return offreAbonnementDAO.trouverOffreAbonnementParId(id);
    }

    // Lister toutes les offres d'abonnement
    public List<OffreAbonnement> listerOffresAbonnement() {
        return offreAbonnementDAO.listerOffresAbonnement();
    }

    // Supprimer une offre d'abonnement par son ID
    public void supprimerOffreAbonnement(int id) {
        offreAbonnementDAO.supprimerOffreAbonnement(id);
    }

    // Vérifier si une offre d'abonnement existe déjà
    public boolean verifierDoublon(OffreAbonnement offreAbonnement) {
        return offreAbonnementDAO.verifierDoublon(offreAbonnement);
    }
}
