package MVVM.Model.Employee;

import shared.DataModel.*;
import Client.EmployeeClient.EmployeeClient;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public interface EmployeeModel{

    void setClient(EmployeeClient client);

    void approveReservation(String reservationID) throws RemoteException;

    void deleteReservation(String reservationID) throws RemoteException;

    void addCar(String registrationNumber,String make,int mileage,String color,int productionYear,String category,int price, int availability) throws RemoteException;

    void deleteCar(String carRegNo) throws RemoteException;

    void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException;

    Car getCar(String registrationNumber) throws RemoteException;

    CarList getCars() throws RemoteException;

    Reservation getReservation(String username) throws RemoteException;

    ReservationList getReservations() throws RemoteException;

    void addListener(String eventName, PropertyChangeListener listener) throws RemoteException;

    CustomerList getCustomers() throws RemoteException;
}
