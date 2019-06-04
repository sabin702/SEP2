package Client;

import DataModel.*;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public class ClientImpl implements Client {

    private CarList cars;
    private IRMIClient client;

    public ClientImpl(IRMIClient client){
        cars = new CarList();
        this.client = client;
    }

    @Override
    public boolean logIn(String username, String password) throws RemoteException {
        return client.logIn(username, password);
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
    public void addReservation(Reservation reservation) throws RemoteException {
        client.addReservation(reservation);
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
    public void addCustomer(Customer customer) throws RemoteException {
        client.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(String username) throws RemoteException {
        client.deleteCustomer(username);
    }

    @Override
    public void editCustomer(String username, String firstName, String lastName, String password) throws RemoteException {
        client.editCustomer(username, firstName, lastName, password);
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
    public void updateReservationList(ReservationList reservations) throws RemoteException {
        //client.updateReservationList(reservations);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) throws RemoteException {
        client.addListener(eventName, listener);
    }

    /*@Override
    public void addListener(String eventName, PropertyChangeListener listener) throws RemoteException {
        client.addListener(eventName, listener);
    }*/

    @Override
    public ReservationList updateReservations() throws RemoteException {
        return client.updateReservations();
    }

    @Override
    public void fireUpdateReservations() throws RemoteException {
        client.fireUpdateReservations();
    }

    @Override
    public void fireUpdateUsers() throws RemoteException {
        client.fireUpdateUsers();
    }

    @Override
    public void fireUpdateCars() throws RemoteException {
        client.fireUpdateCars();
    }




    /*public void addServerListener(IServerListener listener)
    {
        client.addServerListener(listener);
    }*/

}
