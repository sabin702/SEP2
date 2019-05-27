package Model;

import DataModel.Customer;
import DataModel.ReservationList;
import Employee_Client.Client;
import Employee_Client.CustomerClient;

public interface CustomerModel {

    void setClient(CustomerClient client);

    void createAccount(Customer customer);

    void logIn(String username, String password);

    void makeReservation();

    void deleteReservation();

    void changeUserData();

    ReservationList viewReservations();

}
