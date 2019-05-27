package Employee_Client;

import DataModel.*;

import java.rmi.RemoteException;
import java.util.Date;

public interface CustomerClient {

    Car getCar(String registrationNumber);

    CarList getCars() throws RemoteException;

    void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    Reservation getReservation(String registrationId);

    ReservationList getReservations() throws RemoteException;

    void addCustomer(Customer customer) throws RemoteException;

    void deleteCustomer(String username);

    Customer getCustomer(String username);

    CustomerList getCustomers();

}
