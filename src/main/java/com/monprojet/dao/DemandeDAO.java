package com.monprojet.dao;

import com.monprojet.models.Demande;
import java.util.List;

public interface DemandeDAO {
    void ajouterDemande(Demande demande);
    Demande trouverDemandeParId(int id);
    List<Demande> listerDemandes();
    void supprimerDemande(int id);
    boolean verifierDoublon(Demande demande);
}
