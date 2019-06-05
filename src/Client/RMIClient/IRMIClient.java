package Client.RMIClient;

import DataModel.*;

import java.beans.PropertyChangeListener;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMIClient extends Remote {

    boolean logIn(String username, String password) throws RemoteException;

    void addCar(Car car) throws RemoteException;

    void deleteCar(String carRegistrationNumber) throws RemoteException;

    void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException;

    Car getCar(String registrationNumber) throws RemoteException;

    CarList getCars() throws RemoteException;

    void addReservation(Reservation reservation) throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    void approveReservation(String reservationID) throws RemoteException;

    Reservation getReservation(String reservationId) throws RemoteException;

    ReservationList getReservations() throws RemoteException;

    ReservationList getCustomerReservations() throws RemoteException;

    void addCustomer(Customer customer) throws RemoteException;

    void deleteCustomer(String username) throws RemoteException;

    void editCustomer(String username, String firstName, String lastName, String password) throws RemoteException;

    Customer getCustomer(String username) throws RemoteException;

    CustomerList getCustomers() throws RemoteException;

    void addListener(String event, PropertyChangeListener listener)throws RemoteException;
    void fireUpdateReservations() throws RemoteException;
    void fireUpdateUsers() throws RemoteException;
    void fireUpdateCars() throws RemoteException;
    void fireUpdateCustomerReservations() throws RemoteException;



}
