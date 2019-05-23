package server;

import DataModel.CarList;
import DataModel.ReservationList;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface IServerModel extends Remote {

    void addCar(String registration, String make, int mileage, String color, int productionYear, int availability) throws RemoteException;

    void deleteCar(String carRegistrationNumber) throws RemoteException;

    CarList getCars() throws RemoteException;

    void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException;

    void deleteReservation(String reservationId) throws RemoteException;

    ReservationList getReservations() throws RemoteException;

    void addCustomer(String username, String password, String firstName, String lastName, Date dateOfBirth) throws RemoteException;
}
