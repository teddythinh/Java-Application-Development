package dataAccess;

import java.sql.*;
import java.util.logging.*;

public class MyConnection {
    public static Connection create() {
        Connection connection;
        try {
            Driver myDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(myDriver);

            String SERVERNAME = "localhost";
            String MYDATABASE = "abcd";
            String DB_URL = "jdbc:mysql://" + SERVERNAME + "/" + MYDATABASE;

            String USER = "root";
            String PASSWORD = "123";
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
