package database;

import DataModel.*;

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

        connectToDatabase();

    }

    public void addCar(Car car){
        String sql = "INSERT INTO  \"SEP2\".car " + "VALUES('" + car.getRegistrationNumber() + "','" +
                car.getMake() + "'," +
                car.getMileage() +",'" +
                car.getColor() + "'," +
                car.getProductionYear() + ",'" +
                car.getCategory() + "'," +
                car.getPrice() + "," +
                car.getAvailability() + ")";

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


    //Here we delete cars from the database by the registration number of the car
    public void deleteCar(String registrationNumber){

        //If the user is dumb enough and gives us a
        // registration number for the car longer than 6 characters we're going
        // to drop the connection to the database

        String sql = "DELETE FROM \"SEP2\".car " + "WHERE registrationNumber=" + "'" + registrationNumber + "'";
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

    public void editCar(String registrationNumber, int mileage, int price, int availability){
        String sql = "UPDATE \"SEP2\".car SET "
                + "mileage=" + mileage + ", "
                + "price=" + price + ", "
                + "availability=" + availability
                + " WHERE registrationNumber="
                + "'" + registrationNumber + "'";

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

    public Car getCar(String regNo){
        String sql = "SELECT * FROM \"SEP2\".car WHERE registrationNumber= " + "'" +  regNo + "'";

        Car car = new Car("", "", 0, "", 0, "", 0, 0);

        try {
            connectToDatabase();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                String registrationNumber = rs.getString("registrationNumber");
                String make = rs.getString("make");
                int mileage = rs.getInt("mileage");
                String color = rs.getString("color");
                int productionYear = rs.getInt("model_year");
                String category = rs.getString("category");
                int price = rs.getInt("price");
                int availability = rs.getInt("availability");

                car = new Car(registrationNumber, make, mileage, color, productionYear, category, price, availability);

            }
            rs.close();

            //stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;

    }

    public CarList getCars(){
        String sql = "SELECT * FROM \"SEP2\".car";

        CarList cars = new CarList();

        try {
            connectToDatabase();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                String registrationNumber = rs.getString("registrationNumber");
                String make = rs.getString("make");
                int mileage = rs.getInt("mileage");
                String color = rs.getString("color");
                int productionYear = rs.getInt("model_year");
                String category = rs.getString("category");
                int price = rs.getInt("price");
                int availability = rs.getInt("availability");

                cars.addCar(new Car(registrationNumber, make, mileage, color, productionYear, category, price, availability));

            }
            rs.close();

            //stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
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
            connectToDatabase();

            stmt.executeUpdate(sql);

            stmt.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Unsuccessful sql insert (addReservation() method in Database.java)");
            e.printStackTrace();
        }
    }

    public void deleteReservation(String reservationId){

        String sql = "DELETE FROM \"SEP2\".reservation " + "WHERE reservationId=" + "'" + reservationId + "'";

        try {
            connectToDatabase();

            stmt.executeUpdate(sql);

            stmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Reservation getReservation(String reservationId){
        String sql = "SELECT * FROM \"SEP2\".reservation WHERE reservationId = '" +  reservationId + "'";

        Reservation reservation = new Reservation("", "", "", new Date(), new Date(), 0, 0, "", "", 0, 0, 0, 0);

        try {

            connectToDatabase();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                String reservationID = rs.getString("reservationId");
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

                reservation = new Reservation(reservationID, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservation;
    }

    public ReservationList getReservations(){
        String sql = "SELECT * FROM \"SEP2\".reservation";

        ReservationList reservations = new ReservationList();

        try {
            connectToDatabase();

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
        } catch (SQLException e) {
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

    public void deleteCustomer(String username){
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

    public Customer getCustomer(String username){
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

    public CustomerList getCustomers(){
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

            //stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void connectToDatabase(){
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "1357");
            System.out.println("Database open ok");

            stmt = c.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
