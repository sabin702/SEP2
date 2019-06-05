package Client.EmployeeClient;

import shared.DataModel.*;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public interface EmployeeClient {

    void addCar(Car car) throws RemoteException;

    void deleteCar(String carRegistrationNumber) throws RemoteException;

    void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException;

    Car getCar(String registrationNumber) throws RemoteException;

    CarList getCars() throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    void approveReservation(String reservationId) throws RemoteException;

    Reservation getReservation(String reservationId) throws RemoteException;

    ReservationList getReservations() throws RemoteException;

    Customer getCustomer(String username) throws RemoteException;

    CustomerList getCustomers() throws RemoteException;

    void addListener(String eventName, PropertyChangeListener listener) throws RemoteException;

}
