package com.monprojet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    // Configuration de la base de données
    private static final String URL = "jdbc:mysql://localhost:3306/auto_navette"; // Nom de la base de données
    private static final String USER = "root"; // Nom d'utilisateur MySQL
    private static final String PASSWORD = "12345"; // Mot de passe de la base de données

    // Méthode pour se connecter à la base de données
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Méthode pour vérifier l'authentification d'un utilisateur
    public boolean checkLogin(String email, String motDePass) {
        // Requête SQL avec des paramètres
        String sql = "SELECT * FROM users WHERE email = ? AND motDePass = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            // Remplacer les paramètres dans la requête
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, motDePass);

            // Exécution de la requête
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Si un résultat est trouvé, l'utilisateur existe
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
