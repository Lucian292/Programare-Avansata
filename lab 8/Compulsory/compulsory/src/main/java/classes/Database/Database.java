package classes.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database {
    private static final String URL = "jdbc:mysql://127.0.0.2:3306/albums";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
        }
        return connection;
    }

    public static void deleteAll(String tableName) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM " + tableName;
            ((Statement) stmt).executeUpdate(query);
            con.commit();
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = null;
    }

    public static void rollback() {
        try {
            if (connection != null) {
                connection.rollback(); // rollback the transaction
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}