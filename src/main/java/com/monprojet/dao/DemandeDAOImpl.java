package com.monprojet.dao;

import com.monprojet.models.Demande;
import com.monprojet.jdbc.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DemandeDAOImpl implements DemandeDAO {

    private Database database;

    // Constructeur pour initialiser la connexion à la base de données via Database
    public DemandeDAOImpl(Database database) {
        this.database = database;
    }

    @Override
    public void ajouterDemande(Demande demande) {
        database.insert("demandes", demande.getVilleDepart(), demande.getVilleArrivee(), demande.getHeureDepart(), 
                        demande.getHeureArrivee(), demande.getPeriodeDebut(), demande.getPeriodeFin());
    }

    @Override
    public Demande trouverDemandeParId(int id) {
        String query = "SELECT * FROM demandes WHERE id = ?";
        String[][] result = database.select("demandes", "id", id);
        
        if (result != null && result.length > 1) {
            String[] row = result[1];
            Demande demande = new Demande();
            demande.setId(Integer.parseInt(row[0]));
            demande.setVilleDepart(row[1]);
            demande.setVilleArrivee(row[2]);
            demande.setHeureDepart(row[3]);
            demande.setHeureArrivee(row[4]);
            demande.setPeriodeDebut(row[5]);
            demande.setPeriodeFin(row[6]);
            return demande;
        }
        return null;
    }

    @Override
    public List<Demande> listerDemandes() {
        List<Demande> demandes = new ArrayList<>();
        String[][] result = database.select("demandes");
        
        if (result != null && result.length > 1) {
            for (int i = 1; i < result.length; i++) {
                String[] row = result[i];
                Demande demande = new Demande();
                demande.setId(Integer.parseInt(row[0]));
                demande.setVilleDepart(row[1]);
                demande.setVilleArrivee(row[2]);
                demande.setHeureDepart(row[3]);
                demande.setHeureArrivee(row[4]);
                demande.setPeriodeDebut(row[5]);
                demande.setPeriodeFin(row[6]);
                demandes.add(demande);
            }
        }
        return demandes;
    }

    @Override
    public void supprimerDemande(int id) {
        String query = "DELETE FROM demandes WHERE id = ?";
        try (Connection connection = database.getDb();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean verifierDoublon(Demande demande) {
        String query = "SELECT COUNT(*) FROM demandes WHERE ville_depart = ? AND ville_arrivee = ? AND periode_debut = ? AND periode_fin = ?";
        try (Connection connection = database.getDb();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, demande.getVilleDepart());
            statement.setString(2, demande.getVilleArrivee());
            statement.setString(3, demande.getPeriodeDebut());
            statement.setString(4, demande.getPeriodeFin());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
