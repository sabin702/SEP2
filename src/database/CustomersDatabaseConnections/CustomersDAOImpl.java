package database.CustomersDatabaseConnections;

import shared.DataModel.Customer;
import shared.DataModel.CustomerList;
import database.Database;

import java.sql.*;
import java.util.Date;

public class CustomersDAOImpl implements CustomersDAO{

    private Connection c;

    private Statement stmt;

    private Database database;

    public CustomersDAOImpl(Database database) {
       this.database = database;

        c = database.getC();

        stmt = database.getStmt();
    }

    @Override
    public void addCustomer(String username, String password, String firstName, String lastName, Date dateOfBirth) {
        String sql = "INSERT INTO  \"SEP2\".customer " + "VALUES('" + username + "','"
                + password + "','"
                + firstName + "','"
                + lastName + "','"
                + dateOfBirth + "')";

        connectToDatabase();

        try {
            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Unsuccessful sql insert (addCar() method in Database.java)");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String username) {
        String sql = "DELETE FROM \"SEP2\".customer" + "WHERE username =" + username;

        connectToDatabase();

        try {
            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCustomer(String username, String firstName, String lastName, String password) {
        String sql = "UPDATE \"SEP2\".customer SET "
                + "firstName='" + firstName + "', "
                + "lastName='" + lastName + "', "
                + "password='" + password
                + "' WHERE username="
                + "'" + username + "'";

        try {

            connectToDatabase();

            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Oops something went wrong with " +
                    "the sql syntax for deleting a car(Database.java)");
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String username) {
        String sql = "SELECT * FROM \"SEP2\".customer" + " WHERE username ="
                + "'" + username + "'";

        Customer customer = new Customer("", "", "", "", new Date());

        try {
            connectToDatabase();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                String userName = rs.getString("username");
                String password = rs.getString("password");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Date birthDate = rs.getDate("dateOfBirth");

                customer = new Customer(userName, password, firstName, lastName, birthDate);
            }
            rs.close();

            //stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public CustomerList getCustomers() {
        String sql = "SELECT * FROM \"SEP2\".customer";

        CustomerList customers = new CustomerList();

        try {
            connectToDatabase();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                Date birthDate = rs.getDate("dateOfBirth");

                customers.addCustomer(new Customer(username, password, firstName, lastName, birthDate));
            }
            rs.close();

            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void connectToDatabase() {
        c = database.getC();
        stmt = database.getStmt();
    }
}
