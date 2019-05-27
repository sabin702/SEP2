package Employee_Client;

import DataModel.*;

import java.rmi.RemoteException;
import java.util.Date;

public interface EmployeeClient {

    void addCar(String registration, String make, int mileage, String color, int productionYear, int availability) throws RemoteException;

    void deleteCar(String carRegistrationNumber) throws RemoteException;

    Car getCar(String regisytrationNumber);

    CarList getCars() throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    Reservation getReservation(String registrationId);

    ReservationList getReservations() throws RemoteException;

    void deleteCustomer(String username);

    Customer getCustomer(String username);

    CustomerList getCustomers();

}
