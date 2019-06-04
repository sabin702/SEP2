package database.ReservationDatabaseConnection;

import DataModel.Reservation;
import DataModel.ReservationList;
import database.Database;

import java.sql.*;
import java.util.Date;

public class ReservationsDAOImpl implements ReservationsDAO{

    private Connection c;

    private Statement stmt;

    private Database database;

    public ReservationsDAOImpl() {
        database = new Database();

        c = database.getC();

        stmt = database.getStmt();

       /* c = null;
        stmt = null;

        connectToDatabase();*/
    }

    @Override
    public void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) {
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

    @Override
    public void deleteReservation(String reservationId) {
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

    @Override
    public void approveReservation(String reservationId) {
        String sql = "UPDATE \"SEP2\".reservation SET "
                + "status=" + 1
                + " WHERE reservationId="
                + "'" + reservationId + "'";

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
    public Reservation getReservation(String reservationId) {
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

    @Override
    public ReservationList getReservations() {
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

    @Override
    public void connectToDatabase() {
        c = database.getC();
        stmt = database.getStmt();
    }
}
