package Model;

import DataModel.Customer;
import DataModel.ReservationList;

public interface CustomerModel {

    void createAccount(Customer customer);

    void logIn(String username, String password);

    void makeReservation();

    void deleteReservation();

    void changeUserData();

    ReservationList viewReservations();
}
