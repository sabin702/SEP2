package database.ReservationDatabaseConnection;

import shared.DataModel.Reservation;
import shared.DataModel.ReservationList;

import java.util.Date;

public interface ReservationsDAO {

    void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status);

    void deleteReservation(String reservationId);

    void approveReservation(String reservationId);

    Reservation getReservation(String reservationId);

    ReservationList getReservations();

    ReservationList getCustomerReservations(String userName);

    void connectToDatabase();

}
