package database;

import DataModel.*;

import java.io.Serializable;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Database implements Serializable {

    Connection c;
    Statement stmt;

    public Database() {
        c = null;
        stmt = null;

        //Here we make the connection to our database with the credentials

        connectToDatabase();

    }

    public void addCar(Car car){

    }


    //Here we delete cars from the database by the registration number of the car
    public void deleteCar(String registrationNumber){


    }

    public void editCar(String registrationNumber, int mileage, int price, int availability){

    }

    public Car getCar(String regNo){
       return null;

    }

    public CarList getCars(){
        return null;
    }

    public void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status){


    }

    public void deleteReservation(String reservationId){



    }

    public void approveReservation(String reservationId){

    }

    public Reservation getReservation(String reservationId){
        return null;
    }

    public ReservationList getReservations(){
        return null;
    }

    public void addCustomer(String username, String password, String firstName, String lastName, Date dateOfBirth){

    }

    public void deleteCustomer(String username){

    }

    public void editCustomer(String username, String firstName, String lastName, String password){

    }

    public Customer getCustomer(String username){
        return null;
    }

    public CustomerList getCustomers(){
        return null;    }

    public void connectToDatabase(){
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "password");
            System.out.println("Database open ok");

            stmt = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getC() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "password");
            System.out.println("Database open ok");
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
}
