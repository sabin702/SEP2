package Client.EmployeeClient;

import Client.RMIClient.IRMIClient;
import DataModel.*;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public class EmployeeClientImpl implements EmployeeClient{

    private IRMIClient client;

    public EmployeeClientImpl(IRMIClient client) {
        this.client = client;
    }

    @Override
    public void addCar(Car car) throws RemoteException {
        client.addCar(car);
    }

    @Override
    public void deleteCar(String carRegistrationNumber) throws RemoteException {
        client.deleteCar(carRegistrationNumber);
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
    public void deleteReservation(String reservationId) throws RemoteException {
        client.deleteReservation(reservationId);
    }

    @Override
    public void approveReservation(String reservationId) throws RemoteException {
        client.approveReservation(reservationId);
    }

    @Override
    public Reservation getReservation(String reservationId) throws RemoteException {
        return client.getReservation(reservationId);
    }

    @Override
    public ReservationList getReservations() throws RemoteException {
        return client.getReservations();
    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return client.getCustomer(username);
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
