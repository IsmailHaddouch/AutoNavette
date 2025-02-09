package com.monprojet.dao;

import com.monprojet.models.OffreNavette;
import com.monprojet.jdbc.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OffreNavetteDAOImpl implements OffreNavetteDAO {

    @Override
    public List<OffreNavette> getAllOffers() {
        List<OffreNavette> offers = new ArrayList<>();
        String sql = "SELECT * FROM offres_navettes";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                OffreNavette offer = new OffreNavette();
                offer.setId(rs.getInt("id"));
                offer.setEntp_id(rs.getInt("entp_id"));
                offer.setDateDebut(rs.getDate("date_debut"));
                offer.setDateFin(rs.getDate("date_fin"));
                offer.setVille_depart(rs.getString("ville_depart"));
                offer.setVille_arrive(rs.getString("ville_arrive"));
                offer.setHeure_depart(rs.getString("heure_depart"));
                offer.setHeure_arrive(rs.getString("heure_arrive"));
                offer.setAbonnes_cibles(rs.getInt("abonnes_cibles"));
                offer.setAbonnes_actuels(rs.getInt("abonnes_actuels"));
                offer.setDescription(rs.getString("description"));
                offers.add(offer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offers;
    }

    @Override
    public OffreNavette getOfferById(int id) {
        OffreNavette offer = null;
        String sql = "SELECT * FROM offres_navettes WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    offer = new OffreNavette();
                    offer.setId(rs.getInt("id"));
                    offer.setEntp_id(rs.getInt("entp_id"));
                    offer.setDateDebut(rs.getDate("date_debut"));
                    offer.setDateFin(rs.getDate("date_fin"));
                    offer.setVille_depart(rs.getString("ville_depart"));
                    offer.setVille_arrive(rs.getString("ville_arrive"));
                    offer.setHeure_depart(rs.getString("heure_depart"));
                    offer.setHeure_arrive(rs.getString("heure_arrive"));
                    offer.setAbonnes_cibles(rs.getInt("abonnes_cibles"));
                    offer.setAbonnes_actuels(rs.getInt("abonnes_actuels"));
                    offer.setDescription(rs.getString("description"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offer;
    }

    @Override
    public boolean addOffer(OffreNavette offer) {
        String sql = "INSERT INTO offres_navettes (entp_id, date_debut, date_fin, ville_depart, ville_arrive, heure_depart, heure_arrive, abonnes_cibles, abonnes_actuels, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, offer.getEntp_id());
            ps.setDate(2, new java.sql.Date(offer.getDateDebut().getTime()));
            ps.setDate(3, new java.sql.Date(offer.getDateFin().getTime()));
            ps.setString(4, offer.getVille_depart());
            ps.setString(5, offer.getVille_arrive());
            ps.setString(6, offer.getHeure_depart());  // Correction ici
            ps.setString(7, offer.getHeure_arrive());  // Correction ici
            ps.setInt(8, offer.getAbonnes_cibles());
            ps.setInt(9, offer.getAbonnes_actuels());
            ps.setString(10, offer.getDescription());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateOffer(OffreNavette offer) {
        String sql = "UPDATE offres_navettes SET entp_id = ?, date_debut = ?, date_fin = ?, ville_depart = ?, ville_arrive = ?, heure_depart = ?, heure_arrive = ?, abonnes_cibles = ?, abonnes_actuels = ?, description = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, offer.getEntp_id());
            ps.setDate(2, new java.sql.Date(offer.getDateDebut().getTime()));
            ps.setDate(3, new java.sql.Date(offer.getDateFin().getTime()));
            ps.setString(4, offer.getVille_depart());
            ps.setString(5, offer.getVille_arrive());
            ps.setString(6, offer.getHeure_depart());  // Correction ici
            ps.setString(7, offer.getHeure_arrive());  // Correction ici
            ps.setInt(8, offer.getAbonnes_cibles());
            ps.setInt(9, offer.getAbonnes_actuels());
            ps.setString(10, offer.getDescription());
            ps.setInt(11, offer.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOffer(int id) {
        String sql = "DELETE FROM offres_navettes WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
