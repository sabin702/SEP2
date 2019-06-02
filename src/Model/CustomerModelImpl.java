package Model;

import Client.Client;
import Client.ClientProvider;
import DataModel.CarList;
import DataModel.Customer;
import DataModel.Reservation;
import DataModel.ReservationList;
import Client.IServerListener;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

public class CustomerModelImpl implements CustomerModel, Serializable {

    private Client client;
    private ClientProvider provider;

    public CustomerModelImpl()  {

    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void createAccount(String username, String password, String firstName, String lastName, Date dateOfBirth) {
        try {
            Customer customer = new Customer(username, password, firstName, lastName, dateOfBirth);
            client.addCustomer(customer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return client.getCustomer(username);
    }

    @Override
    public boolean logIn(String username, String password) {
        try {
            return client.logIn(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void makeReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException {
        Reservation reservation = new Reservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);
        client.addReservation(reservation);
    }

    @Override
    public void deleteReservation(String reservationId) throws RemoteException {
        Reservation reservation = client.getReservation(reservationId);
        client.deleteReservation(reservationId);
        //changeSupport.firePropertyChange("ReservationDeleted", null, reservation);
    }

    @Override
    public Reservation getReservation(String reservationId) throws RemoteException {
        return client.getReservation(reservationId);
    }

    @Override
    public void changeUserData() {

    }

    @Override
    public ReservationList viewReservations() throws RemoteException {
        return client.getReservations();
    }

    @Override
    public CarList getCars() throws RemoteException {
        return client.getCars();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) throws RemoteException {
        client.addListener(eventName, listener);
        System.out.println("addListener method");
    }

    public void addListener(IServerListener listener) {
        try {
            client.addServerListener(listener);
            System.out.println("Dodany listener");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
