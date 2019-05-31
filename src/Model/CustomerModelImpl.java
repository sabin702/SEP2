package Model;

import DataModel.CarList;
import DataModel.Customer;
import DataModel.Reservation;
import DataModel.ReservationList;
import Client.Client;
import Client.RMIClient;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.Date;

public class CustomerModelImpl implements CustomerModel {

    private Client client;
    private ReservationList res;

    public CustomerModelImpl()  {

    }

    @Override
    public void setClient(RMIClient client) {
        this.client = client;
        try {
            res = client.getReservations();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
        return client.logIn(username, password);
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
    public void addListener(String eventName, PropertyChangeListener listener) {
        //changeSupport.addPropertyChangeListener(eventName, listener);
    }
}
