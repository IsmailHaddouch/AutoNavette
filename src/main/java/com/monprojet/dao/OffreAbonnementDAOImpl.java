package com.monprojet.dao;

import com.monprojet.models.OffreAbonnement;
import com.monprojet.jdbc.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OffreAbonnementDAOImpl implements OffreAbonnementDAO {
    private Database database;

    public OffreAbonnementDAOImpl(Database database) {
        this.database = database;
    }

    @Override
    public void ajouterOffreAbonnement(OffreAbonnement offreAbonnement) {
        String query = "INSERT INTO offre_abonnement (date_debut, date_fin, nb_abonnes_voulus, nb_abonnes_atteints, statut) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = database.getDb().prepareStatement(query)) {
            stmt.setString(1, offreAbonnement.getDateDebut());
            stmt.setString(2, offreAbonnement.getDateFin());
            stmt.setInt(3, offreAbonnement.getNbAbonnesVoulus());
            stmt.setInt(4, offreAbonnement.getNbAbonnesAtteints());
            stmt.setString(5, offreAbonnement.getStatut());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while adding subscription offer: " + e.getMessage());
        }
    }

    @Override
    public OffreAbonnement trouverOffreAbonnementParId(int id) {
        String query = "SELECT * FROM offre_abonnement WHERE id = ?";
        try (PreparedStatement stmt = database.getDb().prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new OffreAbonnement(
                            rs.getInt("id"),
                            rs.getString("date_debut"),
                            rs.getString("date_fin"),
                            rs.getInt("nb_abonnes_voulus"),
                            rs.getInt("nb_abonnes_atteints"),
                            rs.getString("statut")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while finding subscription offer: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<OffreAbonnement> listerOffresAbonnement() {
        List<OffreAbonnement> offres = new ArrayList<>();
        String query = "SELECT * FROM offre_abonnement";
        try (Statement stmt = database.getDb().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                OffreAbonnement offre = new OffreAbonnement(
                        rs.getInt("id"),
                        rs.getString("date_debut"),
                        rs.getString("date_fin"),
                        rs.getInt("nb_abonnes_voulus"),
                        rs.getInt("nb_abonnes_atteints"),
                        rs.getString("statut")
                );
                offres.add(offre);
            }
        } catch (SQLException e) {
            System.out.println("Error while listing subscription offers: " + e.getMessage());
        }
        return offres;
    }

    @Override
    public void supprimerOffreAbonnement(int id) {
        String query = "DELETE FROM offre_abonnement WHERE id = ?";
        try (PreparedStatement stmt = database.getDb().prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting subscription offer: " + e.getMessage());
        }
    }

    @Override
    public boolean verifierDoublon(OffreAbonnement offreAbonnement) {
        String query = "SELECT COUNT(*) FROM offre_abonnement WHERE date_debut = ? AND date_fin = ? AND statut = ?";
        try (PreparedStatement stmt = database.getDb().prepareStatement(query)) {
            stmt.setString(1, offreAbonnement.getDateDebut());
            stmt.setString(2, offreAbonnement.getDateFin());
            stmt.setString(3, offreAbonnement.getStatut());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while checking duplicate subscription offer: " + e.getMessage());
        }
        return false;
    }
}
