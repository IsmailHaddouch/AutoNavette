package com.monprojet.jdbc;

import java.sql.*;

public class Database {
    private DataSource dataSource;
    private Connection db;

    public Database(DataSource ds) {
        dataSource = ds;
        db = ds.getConnection();
    }

    public String[][] executeQuery(String query) {
        try (Statement sql = db.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = sql.executeQuery(query)) {

            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();

            ResultSetMetaData rsm = rs.getMetaData();
            int cols = rsm.getColumnCount();
            String[][] data = new String[rows + 1][cols];

            // Add column names
            for (int i = 0; i < cols; i++) {
                data[0][i] = rsm.getColumnName(i + 1);
            }

            // Add row data
            int row = 0;
            while (rs.next()) {
                row++;
                for (int i = 0; i < cols; i++) {
                    data[row][i] = rs.getString(i + 1);
                }
            }
            return data;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public String[][] select(String tableName) {
        return executeQuery("SELECT * FROM " + tableName);
    }

    public String[][] select(String tableName, String columnName, Object value) {
        String query = "SELECT * FROM " + tableName + " WHERE " + columnName + "=?";
        return executePreparedQuery(query, value);
    }

    public String[][] selectLike(String tableName, String columnName, Object value) {
        String query = "SELECT * FROM " + tableName + " WHERE " + columnName + " LIKE ?";
        return executePreparedQuery(query, "%" + value + "%");
    }

    private String[][] executePreparedQuery(String query, Object value) {
        try (PreparedStatement stmt = db.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            stmt.setObject(1, value);

            try (ResultSet rs = stmt.executeQuery()) {
                rs.last();
                int rows = rs.getRow();
                rs.beforeFirst();

                ResultSetMetaData rsm = rs.getMetaData();
                int cols = rsm.getColumnCount();
                String[][] data = new String[rows + 1][cols];

                // Add column names
                for (int i = 0; i < cols; i++) {
                    data[0][i] = rsm.getColumnName(i + 1);
                }

                // Add row data
                int row = 0;
                while (rs.next()) {
                    row++;
                    for (int i = 0; i < cols; i++) {
                        data[row][i] = rs.getString(i + 1);
                    }
                }
                return data;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public int insert(String tableName, Object... row) {
        try {
            StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " VALUES(");
            for (int i = 0; i < row.length; i++) {
                query.append(i == 0 ? "?" : ", ?");
            }
            query.append(")");
            PreparedStatement stmt = db.prepareStatement(query.toString());

            for (int i = 0; i < row.length; i++) {
                stmt.setObject(i + 1, row[i]);
            }
            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
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
}
