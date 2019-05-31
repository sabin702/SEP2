package server;

import Client.Client;
import DataModel.*;

import java.beans.PropertyChangeListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface IServerModel extends Remote {

    boolean logIn(String userName, String password, Client client);

    void addClient(Client client);

    void addCar(Car car) throws RemoteException;

    void deleteCar(String carRegistrationNumber) throws RemoteException;

    void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException;

    Car getCar(String registrationNumber) throws RemoteException;

    CarList getCars() throws RemoteException;

    void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    Reservation getReservation(String registrationId) throws RemoteException;

    ReservationList getReservations() throws RemoteException;

    void addCustomer(String username, String password, String firstName, String lastName, Date dateOfBirth) throws RemoteException;

    void deleteCustomer(String username) throws RemoteException;

    Customer getCustomer(String username) throws RemoteException;

    CustomerList getCustomers() throws RemoteException;

    void addListener(String eventName, PropertyChangeListener listener);
}
