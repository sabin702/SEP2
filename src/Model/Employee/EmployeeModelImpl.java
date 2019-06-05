package Model.Employee;

import DataModel.*;
import Client.EmployeeClient.EmployeeClient;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;

public class EmployeeModelImpl implements EmployeeModel, Serializable{

    private EmployeeClient client;

    @Override
    public void setClient(EmployeeClient client) {
        this.client = client;
    }

    @Override
    public void approveReservation(String reservationID) throws RemoteException {
        client.approveReservation(reservationID);
    }

    @Override
    public void deleteReservation(String reservationID) throws RemoteException {
        client.deleteReservation(reservationID);
    }

    @Override
    public void addCar(String registrationNumber,String make,int mileage,String color,int productionYear,String category,int price, int availability) throws RemoteException {
        Car car = new Car(registrationNumber,make,mileage,color,productionYear,category,price,availability);
        client.addCar(car);
    }

    @Override
    public void deleteCar(String carRegNo) throws RemoteException {
        client.deleteCar(carRegNo);
    }

    @Override
    public void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException {
        client.editCar(registrationNumber, mileage, price, availability);
    }

    @Override
    public Car getCar(String registrationNumber) throws RemoteException {
        return client.getCar(registrationNumber);
    }

    @Override
    public CarList getCars() throws RemoteException {
        return client.getCars();
    }

    @Override
    public Reservation getReservation(String user) throws RemoteException {
        return client.getReservation(user);
    }

    @Override
    public ReservationList getReservations() throws RemoteException {
        return client.getReservations();
    }

    @Override
    public CustomerList getCustomers() throws RemoteException {
        return client.getCustomers();
    }


    @Override
    public void addListener(String eventName, PropertyChangeListener listener) throws RemoteException {
        client.addListener(eventName, listener);
    }
}
