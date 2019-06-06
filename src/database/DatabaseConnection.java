package database;

import java.io.Serializable;
import java.sql.*;

public class DatabaseConnection {

    Connection c;
    Statement stmt;

    public DatabaseConnection() {
        c = null;
        stmt = null;

        //Here we make the connection to our database with the credentials
        connectToDatabase();
    }

    public void connectToDatabase(){
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(getDatabaseUrl(),
                    getDatabaseUser(), getDatabasePassword());
            System.out.println("DatabaseConnection open ok");

            stmt = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getC() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(getDatabaseUrl(),
                    getDatabaseUser(), getDatabasePassword());
            System.out.println("DatabaseConnection open ok");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public Statement getStmt() {
        try {
            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    //Use your database url
    public String getDatabaseUrl(){
        return "jdbc:postgresql://localhost:5432/postgres";
    }

    //Use you DatabaseConnection user
    public String getDatabaseUser(){
        return "postgres";
    }

    //Use your database password
    public String getDatabasePassword(){
        return "1357";
    }
}
