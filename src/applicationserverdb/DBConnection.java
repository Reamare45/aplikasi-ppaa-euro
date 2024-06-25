package applicationserverdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con = null;

    public static Connection connectDB() {
        if (con != null) {
            return con;
        }
        try {
            // Load JDBC driver for SQLite
            Class.forName("org.sqlite.JDBC");

            // Create connection to the database
            con = DriverManager.getConnection("jdbc:sqlite:DataBase.db");
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                con = null;
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}
