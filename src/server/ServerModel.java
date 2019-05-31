package server;

import Client.Client;
import Client.RMIClient;
import DataModel.*;
import database.Database;

import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerModel implements IServerModel, Remote{

    Database database;
    List<Client> clients;

    public ServerModel() {

        try {
            UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("servers", this);

            System.out.println("Server has been started!");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
        database = new Database();
        clients = new ArrayList<Client>();
    }

    @Override
    public boolean logIn(String username, String password, Client client) throws RemoteException{
        if(database.getCustomer(username) == null) {
            System.out.println("No user found");
            return false;
        }
        else if(database.getCustomer(username).getPassword().equals(password)) {
            clients.add(client);
            return true;
        }
        else
            return false;
    }

    @Override
    public void addClient(Client client) throws RemoteException {
        clients.add(client);
    }

    @Override
    public void addCar(Car car) throws RemoteException {
        database.addCar(car);
    }

    @Override
    public void deleteCar(String carRegistrationNumber) throws RemoteException{
        database.deleteCar(carRegistrationNumber);
    }

    @Override
    public void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException{
        database.editCar(registrationNumber, mileage, price, availability);
    }

    @Override
    public Car getCar(String registrationNumber) throws RemoteException{
        return database.getCar(registrationNumber);
    }

    @Override
    public CarList getCars() throws RemoteException {
        return database.getCars();
    }

    @Override
    public void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException {
        database.addReservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);
        for(Client client : clients)
        {
            client.updateReservationList(database.getReservations());
        }
    }

    @Override
    public void deleteReservation(String reservationId) throws RemoteException {
        reservationId = reservationId.toUpperCase();
        database.deleteReservation(reservationId);
    }

    @Override
    public Reservation getReservation(String reservationId) throws RemoteException{
        reservationId = reservationId.toUpperCase();
        return database.getReservation(reservationId);
    }

    @Override
    public ReservationList getReservations() throws RemoteException {
        return database.getReservations();
    }

    @Override
    public void addCustomer(String username, String password, String firstName, String lastName, Date dateOfBirth) throws RemoteException{
        database.addCustomer(username, password, firstName, lastName, dateOfBirth);
    }

    @Override
    public void deleteCustomer(String username) throws RemoteException{
        database.deleteCustomer(username);
    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return database.getCustomer(username);
    }

    @Override
    public CustomerList getCustomers() throws RemoteException{
        return database.getCustomers();
    }

}
