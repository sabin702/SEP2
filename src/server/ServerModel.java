package server;

import Client.IRMIClient;
import DataModel.*;
import database.Database;

import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerModel implements IServerModel {

    private Database database;
    IRMIClient client;
    List<IRMIClient> clients;
    private PropertyChangeSupport changeSupport;
    private ReservationList reservationList;

    public ServerModel() throws RemoteException {

        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        database = new Database();
        changeSupport = new PropertyChangeSupport(this);
        clients = new ArrayList<IRMIClient>();
        reservationList = getReservations();


    }

    @Override
    public boolean logIn(String username, String password, IRMIClient client) throws RemoteException {
        if (database.getCustomer(username) == null) {
            System.out.println("No user found");
            return false;
        } else if (database.getCustomer(username).getPassword().equals(password)) {
            return true;
        } else
            return false;
    }


    @Override
    public void addCar(Car car) throws RemoteException {
        database.addCar(car);
        callClientUpdateCars();
    }

    @Override
    public void deleteCar(String carRegistrationNumber) throws RemoteException {
        database.deleteCar(carRegistrationNumber);
        callClientUpdateCars();
    }

    @Override
    public void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException {
        database.editCar(registrationNumber, mileage, price, availability);
    }

    @Override
    public Car getCar(String registrationNumber) throws RemoteException {
        return database.getCar(registrationNumber);
    }

    @Override
    public CarList getCars() throws RemoteException {
        return database.getCars();
    }

    @Override
    public void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException {
        database.addReservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);
        Reservation reservation = new Reservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);
        reservationList.addReservation(reservation);
        callClientUpdateReservation();

    }

    @Override
    public void deleteReservation(String reservationId) throws RemoteException {
        reservationId = reservationId.toUpperCase();
        Reservation reservation = getReservation(reservationId);
        database.deleteReservation(reservationId);
        /*reservationList.removeReservation();*/
        callClientUpdateReservation();

    }

    @Override
    public Reservation getReservation(String reservationId) throws RemoteException {
        reservationId = reservationId.toUpperCase();
        return database.getReservation(reservationId);
    }

    @Override
    public ReservationList getReservations() throws RemoteException {
        return database.getReservations();
    }

    @Override
    public void addCustomer(String username, String password, String firstName, String lastName, Date dateOfBirth) throws RemoteException {
        database.addCustomer(username, password, firstName, lastName, dateOfBirth);
        callClientUpdateUsers();
    }

    @Override
    public void deleteCustomer(String username) throws RemoteException {
        database.deleteCustomer(username);
    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return database.getCustomer(username);
    }

    @Override
    public CustomerList getCustomers() throws RemoteException {
        return database.getCustomers();
    }

    @Override
    public ReservationList getUpdatedReservationList() {
        return reservationList;
    }




    @Override
    public void callClientUpdateReservation() throws RemoteException {
        System.out.println("call client method");
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).fireUpdateReservations();
        }
    }

    @Override
    public void addClient(IRMIClient c) throws RemoteException {
        clients.add(c);
    }

    @Override
    public void callClientUpdateUsers() throws RemoteException {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).fireUpdateUsers();
        }
    }

    @Override
    public void callClientUpdateCars() throws RemoteException {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).fireUpdateCars();
        }
    }


}
