package Model.Customer;

import Client.CustomerClient.CustomerClient;
import DataModel.CarList;
import DataModel.Customer;
import DataModel.Reservation;
import DataModel.ReservationList;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.Date;

public interface CustomerModel {

    void setClient(CustomerClient client);

    void createAccount(String username, String password, String firstName, String lastName, Date dateOfBirth) throws RemoteException;

    void editCustomer(String username, String firstName, String lastName, String password) throws RemoteException;

    Customer getCustomer(String username) throws RemoteException;

    boolean logIn(String username, String password) throws RemoteException;

    void makeReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    Reservation getReservation(String reservationId) throws RemoteException;

    ReservationList viewReservations() throws RemoteException;

    ReservationList getCustomerReservations() throws RemoteException;

    CarList getCars() throws RemoteException;

    void addListener(String eventName, PropertyChangeListener listener) throws RemoteException;


}