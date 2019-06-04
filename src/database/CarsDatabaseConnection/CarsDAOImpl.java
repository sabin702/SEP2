package database.CarsDatabaseConnection;

import DataModel.Car;
import DataModel.CarList;
import database.Database;

import java.sql.*;

public class CarsDAOImpl implements CarsDAO{

    private Connection c;

    private Statement stmt;

    private Database database;

    public CarsDAOImpl() {

        database = new Database();

        /*c = null;

        stmt = null;

        connectToDatabase();
*/
        c = database.getC();
        stmt = database.getStmt();

    }

    @Override
    public void addCar(Car car) {
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

    @Override
    public void deleteCar(String registrationNumber) {
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

    @Override
    public void editCar(String registrationNumber, int mileage, int price, int availability) {
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

    @Override
    public Car getCar(String regNo) {
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

    @Override
    public CarList getCars() {
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

    @Override
    public void connectToDatabase() {
        c = database.getC();
        stmt = database.getStmt();
    }
}
