package com.monprojet.dao;

import com.monprojet.models.Navette;
import com.monprojet.jdbc.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Navetteimpl implements NavetteDAO {

    private Database database;

    public Navetteimpl(Database database) {
        this.database = database;
    }

    @Override
    public void ajouterNavette(Navette navette) {
        database.insert("navettes", navette.getId(), navette.getVilleDepart(), navette.getVilleArrivee(), navette.getHeureDepart(), navette.getHeureArrivee(), navette.getDescription());
    }

    @Override
    public Navette trouverNavetteParId(int id) {
        String query = "SELECT * FROM navettes WHERE id = ?";
        String[][] result = database.select("navettes", "id", id);
        
        if (result != null && result.length > 1) {
            String[] row = result[1];
            Navette navette = new Navette(
                Integer.parseInt(row[0]),
                row[1],
                row[2],
                row[3],
                row[4],
                row[5]
            );
            return navette;
        }
        return null;
    }

    @Override
    public List<Navette> listerNavettes() {
        List<Navette> navettes = new ArrayList<>();
        String[][] result = database.select("navettes");
        
        if (result != null && result.length > 1) {
            for (int i = 1; i < result.length; i++) {
                String[] row = result[i];
                Navette navette = new Navette(
                    Integer.parseInt(row[0]),
                    row[1],
                    row[2],
                    row[3],
                    row[4],
                    row[5]
                );
                navettes.add(navette);
            }
        }
        return navettes;
    }

    @Override
    public void supprimerNavette(int id) {
        String query = "DELETE FROM navettes WHERE id = ?";
        try (Connection connection = database.getDb();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean verifierDoublon(Navette navette) {
        String query = "SELECT COUNT(*) FROM navettes WHERE ville_depart = ? AND ville_arrivee = ? AND heure_depart = ?";
        try (Connection connection = database.getDb();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, navette.getVilleDepart());
            statement.setString(2, navette.getVilleArrivee());
            statement.setString(3, navette.getHeureDepart());
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
