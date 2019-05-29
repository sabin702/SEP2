package Model;

import DataModel.Customer;
import DataModel.ReservationList;
import CustomerClient.CustomerClient;

import java.rmi.RemoteException;
import java.util.Date;

public interface CustomerModel {

    void setClient(CustomerClient client);

    void createAccount(String username, String password, String firstName, String lastName, Date dateOfBirth);

    Customer getCustomer(String username) throws RemoteException;

    void logIn(String username, String password);

    void makeReservation();

    void deleteReservation();

    void changeUserData();

    ReservationList viewReservations() throws RemoteException;

}
