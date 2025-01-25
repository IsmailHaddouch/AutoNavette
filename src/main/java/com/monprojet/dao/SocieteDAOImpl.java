package com.monprojet.dao;

import com.monprojet.dao.SocieteDAO;
import com.monprojet.models.Societe;
import com.monprojet.jdbc.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SocieteDAOImpl implements SocieteDAO {
    private Database database;

    public SocieteDAOImpl(Database database) {
        this.database = database;
    }

    @Override
    public void ajouterSociete(Societe societe) {
        String query = "INSERT INTO societe (nom, adresse) VALUES (?, ?)";
        try (PreparedStatement stmt = database.getDb().prepareStatement(query)) {
            stmt.setString(1, societe.getNom());
            stmt.setString(2, societe.getAdresse());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while adding company: " + e.getMessage());
        }
    }

    @Override
    public Societe trouverSocieteParId(int id) {
        String query = "SELECT * FROM societe WHERE id = ?";
        try (PreparedStatement stmt = database.getDb().prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Societe(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("adresse")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while finding company: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Societe> listerSocietes() {
        List<Societe> societes = new ArrayList<>();
        String query = "SELECT * FROM societe";
        try (Statement stmt = database.getDb().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Societe societe = new Societe(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("adresse")
                );
                societes.add(societe);
            }
        } catch (SQLException e) {
            System.out.println("Error while listing companies: " + e.getMessage());
        }
        return societes;
    }

    @Override
    public void supprimerSociete(int id) {
        String query = "DELETE FROM societe WHERE id = ?";
        try (PreparedStatement stmt = database.getDb().prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting company: " + e.getMessage());
        }
    }

    @Override
    public boolean verifierDoublon(Societe societe) {
        String query = "SELECT COUNT(*) FROM societe WHERE nom = ? AND adresse = ?";
        try (PreparedStatement stmt = database.getDb().prepareStatement(query)) {
            stmt.setString(1, societe.getNom());
            stmt.setString(2, societe.getAdresse());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while checking duplicate company: " + e.getMessage());
        }
        return false;
    }
}
