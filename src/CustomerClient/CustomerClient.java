package CustomerClient;

import DataModel.*;

import java.rmi.RemoteException;
import java.util.Date;

public interface CustomerClient {

    Car getCar(String registrationNumber);

    CarList getCars() throws RemoteException;

    void addReservation(Reservation reservation) throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    Reservation getReservation(String registrationId) throws RemoteException;

    ReservationList getReservations() throws RemoteException;

    void addCustomer(Customer customer) throws RemoteException;

    

    void deleteCustomer(String username);

    Customer getCustomer(String username) throws RemoteException;

    CustomerList getCustomers() throws RemoteException;

}
