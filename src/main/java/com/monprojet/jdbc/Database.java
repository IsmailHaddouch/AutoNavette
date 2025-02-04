package com.monprojet.jdbc;

import java.sql.*;

public class Database {
    private DataSource dataSource;
    private Connection db;

    public Database(DataSource ds) {
        dataSource = ds;
        db = ds.getConnection();
    }

    public String[][] ExecuteQuery(String query) {
        try {
            Statement sql = db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = sql.executeQuery(query);

            if (!rs.isBeforeFirst()) {
                System.out.println("Aucune donnée trouvée !");
                return new String[0][0]; // Évite de renvoyer null
            }

            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();

            ResultSetMetaData rsm = rs.getMetaData();
            int cols = rsm.getColumnCount();
            String[][] data = new String[rows + 1][cols];

            // Récupération des noms des colonnes
            for (int i = 0; i < cols; i++) {
                data[0][i] = rsm.getColumnName(i + 1);
            }

            int row = 0;
            while (rs.next()) {
                row++;
                for (int i = 0; i < cols; i++) {
                    data[row][i] = rs.getString(i + 1);
                }
            }

            rs.close();
            sql.close();
            return data;

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            return new String[0][0]; // Évite les NullPointerException
        }
    }

    public String[][] Select(String tableName) {
        return ExecuteQuery("SELECT * FROM " + tableName);
    }

    public String[][] Select(String tableName, String columnName, Object value) {
        String query = "SELECT * FROM " + tableName + " WHERE " + columnName + "=?";
        return executePreparedQuery(query, value);
    }

    public String[][] SelectLike(String tableName, String columnName, Object value) {
        String query = "SELECT * FROM " + tableName + " WHERE " + columnName + " LIKE ?";
        return executePreparedQuery(query, "%" + value + "%");
    }

    private String[][] executePreparedQuery(String query, Object value) {
        try (PreparedStatement pstmt = db.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            pstmt.setObject(1, value);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                return new String[0][0];
            }

            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();

            ResultSetMetaData rsm = rs.getMetaData();
            int cols = rsm.getColumnCount();
            String[][] data = new String[rows + 1][cols];

            for (int i = 0; i < cols; i++) {
                data[0][i] = rsm.getColumnName(i + 1);
            }

            int row = 0;
            while (rs.next()) {
                row++;
                for (int i = 0; i < cols; i++) {
                    data[row][i] = rs.getString(i + 1);
                }
            }

            rs.close();
            return data;

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            return new String[0][0];
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        db = dataSource.getConnection();
    }

    public Connection getDb() {
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public int insert(String tableName, Object... row) {
        try {
            String query = "INSERT INTO " + tableName + " VALUES(" + "?, ".repeat(row.length - 1) + "?)";
            PreparedStatement pstmt = db.prepareStatement(query);

            for (int i = 0; i < row.length; i++) {
                pstmt.setObject(i + 1, row[i]);
            }

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            return -1;
        }
    }
}
