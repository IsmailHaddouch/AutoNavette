package com.monprojet.dao;

import com.monprojet.models.User;

public interface UtilisateursDAO {
    /**
      @param username le nom d'utilisateur recherché
      @return l'objet User correspondant ou null si non trouvé
     */
    User getUtilisateurByUsername(String username);

    /**
      @param utilisateur l'utilisateur à ajouter
       @return true si l'insertion s'est déroulée correctement, false sinon
     */
    boolean ajouterUtilisateur(User utilisateur);
}
