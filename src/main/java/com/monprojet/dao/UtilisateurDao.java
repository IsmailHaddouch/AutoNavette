package com.monprojet.dao;

import java.sql.SQLException;
import com.monprojet.models.User;
import com.monprojet.jdbc.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtilisateurDao {

    // Méthode permettant de récupérer un utilisateur à partir de son username
    public User getUtilisateurByUsername(String username) {
        User utilisateur = null;
        String sql = "SELECT * FROM utilisateur WHERE username = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, username);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    utilisateur = new User();
                    utilisateur.setId(rs.getInt("id"));
                    utilisateur.setUsername(rs.getString("username"));
                    utilisateur.setMotDePasse(rs.getString("motDePass"));
                    utilisateur.setTypeUser(rs.getString("typeUser"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }
    
    // Méthode permettant d'ajouter un nouvel utilisateur dans la base de données
    public boolean ajouterUtilisateur(User utilisateur) {
        String sql = "INSERT INTO utilisateur(username, motDePass, typeUser) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, utilisateur.getUsername());
            ps.setString(2, utilisateur.getMotDePass());
            ps.setString(3, utilisateur.getTypeUser());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
