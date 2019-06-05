package server;

import Client.RMIClient.IRMIClient;
import shared.DataModel.*;
import database.CarsDatabaseConnection.CarsDAO;
import database.CarsDatabaseConnection.CarsDAOImpl;
import database.CustomersDatabaseConnections.CustomersDAO;
import database.CustomersDatabaseConnections.CustomersDAOImpl;
import database.ReservationDatabaseConnection.ReservationsDAO;
import database.ReservationDatabaseConnection.ReservationsDAOImpl;

import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerModel implements IServerModel {

    private CarsDAO carsDAO;
    private CustomersDAO customersDAO;
    private ReservationsDAO reservationsDAO;
    List<IRMIClient> clients;
    private PropertyChangeSupport changeSupport;

    public ServerModel() throws RemoteException {

        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        carsDAO = new CarsDAOImpl();
        customersDAO = new CustomersDAOImpl();
        reservationsDAO = new ReservationsDAOImpl();
        changeSupport = new PropertyChangeSupport(this);
        clients = new ArrayList<IRMIClient>();


    }

    @Override
    public boolean logIn(String username, String password, IRMIClient client) throws RemoteException {
        if (customersDAO.getCustomer(username) == null) {
            System.out.println("No user found");
            return false;
        } else if (customersDAO.getCustomer(username).getPassword().equals(password)) {
            return true;
        } else
            return false;
    }


    @Override
    public void addCar(Car car) throws RemoteException {
        carsDAO.addCar(car);
        callClientUpdateCars();
    }

    @Override
    public void deleteCar(String carRegistrationNumber) throws RemoteException {
        carsDAO.deleteCar(carRegistrationNumber);
        callClientUpdateCars();
    }

    @Override
    public void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException {
        carsDAO.editCar(registrationNumber, mileage, price, availability);
    }

    @Override
    public Car getCar(String registrationNumber) throws RemoteException {
        return carsDAO.getCar(registrationNumber);
    }

    @Override
    public CarList getCars() throws RemoteException {
        return carsDAO.getCars();
    }

    @Override
    public void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException {
        reservationsDAO.addReservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);
        callClientUpdateReservation();
        callCustomerClientUpdateReservation();
    }

    @Override
    public void deleteReservation(String reservationId) throws RemoteException {
        reservationId = reservationId.toUpperCase();
        reservationsDAO.deleteReservation(reservationId);
        callClientUpdateReservation();
        callCustomerClientUpdateReservation();
    }

    @Override
    public void approveReservation(String reservationId) throws RemoteException {
        reservationsDAO.approveReservation(reservationId);
        callClientUpdateReservation();
        callCustomerClientUpdateReservation();
    }

    @Override
    public Reservation getReservation(String reservationId) throws RemoteException {
        reservationId = reservationId.toUpperCase();
        return reservationsDAO.getReservation(reservationId);
    }

    @Override
    public ReservationList getReservations() throws RemoteException {
        return reservationsDAO.getReservations();
    }

    @Override
    public ReservationList getCustomerReservations(String userName) throws RemoteException {
        return reservationsDAO.getCustomerReservations(userName);
    }

    @Override
    public void addCustomer(String username, String password, String firstName, String lastName, Date dateOfBirth) throws RemoteException {
        customersDAO.addCustomer(username, password, firstName, lastName, dateOfBirth);
        callClientUpdateUsers();
    }

    @Override
    public void deleteCustomer(String username) throws RemoteException {
        customersDAO.deleteCustomer(username);
    }

    @Override
    public void editCustomer(String username, String firstName, String lastName, String password) throws RemoteException {
        customersDAO.editCustomer(username, firstName, lastName, password);
        callClientUpdateUsers();
    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return customersDAO.getCustomer(username);
    }

    @Override
    public CustomerList getCustomers() throws RemoteException {
        return customersDAO.getCustomers();
    }

    @Override
    public void callClientUpdateReservation() throws RemoteException {
        System.out.println("call client method");
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).fireUpdateReservations();
        }
    }

    @Override
    public void callCustomerClientUpdateReservation() throws RemoteException {
        System.out.println("call customer client method");
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).fireUpdateCustomerReservations();
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
