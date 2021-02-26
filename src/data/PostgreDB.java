package data;

import data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/Med";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "0000");

            return con;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
