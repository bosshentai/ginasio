package sample.data;

import java.sql.*;

public class Datasource {
    public static final String DB_NAME = "ginasio.db";
    public static final String PATCH = "./src/";
    public static final String CONNECTION_STRING = "jdbc:sqlite:" + PATCH + DB_NAME;

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Coudn't close connection" + e.getMessage());
        }
    }

}
