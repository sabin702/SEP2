package database;

import DataModel.Car;
import DataModel.CarList;
import DataModel.Reservation;
import DataModel.ReservationList;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Database {

    Connection c;
    Statement stmt;

    public Database() {
        c = null;
        stmt = null;

        //Here we make the connection to our database with the credentials
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

    public void addCar(String registration, String make, int mileage, String color, int production, int availability){
        String sql = "INSERT INTO  \"SEP2\".car " + "VALUES('" + registration + "','" + make + "'," + mileage +",'" + color + "'," + production + "," + availability + ")";

        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "password");

            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Unsuccessful sql insert (addCar() method in Database.java)");
            e.printStackTrace();
        }
    }


    //Here we delete cars from the database by the registration number of the car
    public void deleteCar(String registrationNumber){

        //If the user is dumb enough and gives us a
        // registration number for the car longer than 6 characters we're going
        // to drop the connection to the database
        if(registrationNumber.length() > 6){
            try {
                stmt.close();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String sql = "DELETE FROM \"SEP2\".car " + "WHERE registrationNumber = " + registrationNumber;
        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "password");
            System.out.println("Database open ok");

            stmt = c.createStatement();

            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Oops something went wrong with " +
                    "the sql syntax for deleting a car(Database.java)");
            e.printStackTrace();
        }
    }

    public void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status){

        Reservation reservation = new Reservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);

        String sql = "INSERT INTO  \"SEP2\".reservation " + "VALUES('" + reservationId + "','"
                + carRegNo + "','"
                + username + "','"
                + dateFrom + "','"
                + dateTo +"','"
                + navigation + "','"
                + childseat + "','"
                + firstName + "','"
                + lastName + "','"
                + age + "','"
                + price + "','"
                + insurance + "','"
                + status + "')";
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "password");
            System.out.println("Database open ok");

            stmt = c.createStatement();

            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Unsuccessful sql insert (addReservation() method in Database.java)");
            e.printStackTrace();
        }
    }

    public void deleteReservation(String registrationId){
        if(registrationId.length() > 6){
            try {
                stmt.close();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String sql = "DELETE FROM \"SEP2\".reservation" + "WHERE registrationId =" + registrationId;

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
    }

    public void getCar(){

    }

    public CarList getCars(){
        String sql = "SELECT * FROM \"SEP2\".car";

        CarList cars = new CarList();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "password");
            System.out.println("Database open ok");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                String registrationNumber = rs.getString("registrationNumber");
                String make = rs.getString("make");
                int mileage = rs.getInt("mileage");
                String color = rs.getString("color");
                int productionYear = rs.getInt("model_year");
                int availability = rs.getInt("availability");

                cars.addCar(new Car(registrationNumber, make, mileage, color, productionYear, availability));

            }
            rs.close();

            //stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public ReservationList getReservations(){
        String sql = "SELECT * FROM \"SEP2\".reservation";

        ReservationList reservations = new ReservationList();

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "password");
            System.out.println("Database open ok");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                String reservationId = rs.getString("reservationId");
                String carRegNo = rs.getString("car_reg_no");
                String username = rs.getString("username");
                Date dateFrom = rs.getDate("dateFrom");
                Date dateTo = rs.getDate("dateTo");
                int navigation = rs.getInt("navigation");
                int childseat = rs.getInt("childseat");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int age = rs.getInt("age");
                int price = rs.getInt("price");
                int insurance = rs.getInt("insurance");
                int status = rs.getInt("status");

                reservations.addReservation(new Reservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status));

            }
            rs.close();

            //stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public void addCustomer(String username, String password, String firstName, String lastName, Date dateOfBirth){
        String sql = "INSERT INTO  \"SEP2\".customer " + "VALUES('" + username + "','"
                + password + "','"
                + firstName + "','"
                + lastName + "','"
                + dateOfBirth + "')";

        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "password");

            stmt = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Unsuccessful sql insert (addCar() method in Database.java)");
            e.printStackTrace();
        }
    }

}
