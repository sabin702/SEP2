package Model;

import DataModel.Car;
import DataModel.CustomerList;
import DataModel.Reservation;
import DataModel.ReservationList;
import Employee_Client.EmployeeClient;

import java.rmi.RemoteException;

public interface EmployeeModel {

    void setClient(EmployeeClient client);

    void approveReservatiokn(String reservationID);

    void deleteReservation(String reservationID);

    void addCar(String registrationNumber,String make,int mileage,String color,int productionYear,String category,int price, int availability) throws RemoteException;

    void deletCar(String carID);

    void editCar();
    Reservation getReservation(String username) throws RemoteException;
    ReservationList getReservations() throws RemoteException;

    CustomerList viewUsers();

}
