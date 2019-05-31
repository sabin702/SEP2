package Employee_Client;

import DataModel.*;

import java.rmi.RemoteException;
import java.util.Date;

public interface EmployeeClient {

    void addCar(Car car) throws RemoteException;

    void deleteCar(String carRegistrationNumber) throws RemoteException;

    void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException;

    Car getCar(String registrationNumber) throws RemoteException;

    CarList getCars() throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    Reservation getReservation(String registrationId) throws RemoteException;

    ReservationList getReservations() throws RemoteException;

    void deleteCustomer(String username);

    Customer getCustomer(String username) throws RemoteException;

    CustomerList getCustomers();

}
