package Model;

import Client.Client;
import Client.IRMIClient;
import Client.IServerListener;
import DataModel.CarList;
import DataModel.Customer;
import DataModel.Reservation;
import DataModel.ReservationList;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.Date;

public interface CustomerModel {

    void setClient(Client client);

    void createAccount(String username, String password, String firstName, String lastName, Date dateOfBirth);

    Customer getCustomer(String username) throws RemoteException;

    boolean logIn(String username, String password);

    void makeReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    Reservation getReservation(String reservationId) throws RemoteException;

    void changeUserData();

    ReservationList viewReservations() throws RemoteException;

    CarList getCars() throws RemoteException;

    void addListener(String eventName, PropertyChangeListener listener);

    void addListener(IServerListener listener);

}
