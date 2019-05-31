package Client;

import DataModel.*;
import Model.CustomerModel;
import Model.EmployeeModel;
import server.IServerModel;

import javax.swing.*;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class RMIClient extends AServerSubject implements Client, Remote {

    IServerModel serverModel;
    CarList cars;
    List<Reservation> reservations;
    private PropertyChangeSupport changeSupport;

    public RMIClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        serverModel = (IServerModel) registry.lookup("servers");
        cars = new CarList();
        reservations = new ArrayList<>();
        changeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public boolean logIn(String username, String password) throws RemoteException{
        try {
            return serverModel.logIn(username, password, this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addCar(Car car) throws RemoteException {
        serverModel.addCar(car);
    }

    @Override
    public void deleteCar(String carRegistrationNumber) throws RemoteException {
        serverModel.deleteCar(carRegistrationNumber);
    }

    @Override
    public void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException {
        serverModel.editCar(registrationNumber, mileage, price, availability);
    }

    @Override
    public Car getCar(String registrationNumber) throws RemoteException {
        return serverModel.getCar(registrationNumber);
    }

    @Override
    public CarList getCars() throws RemoteException {
        return serverModel.getCars();
    }

    @Override
    public void addReservation(Reservation reservation) throws RemoteException {
        try {
            serverModel.addReservation(reservation.getReservationId(), reservation.getCarRegNo(), reservation.getUsername(), reservation.getDateFromObject(), reservation.getDateToObject(), reservation.getNavigation(), reservation.getChildseat(), reservation.getFirstName(), reservation.getLastName(), reservation.getAge(), reservation.getPrice(), reservation.getInsurance(), reservation.getStatus());
            reservations.add(reservation);
            System.out.println("Successfully added reservation");
            changeSupport.firePropertyChange("ReservationAdded", null, reservation);
        } catch (RemoteException e) {
            System.out.println("Add reservation issue");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReservation(String reservationId) throws RemoteException {
        serverModel.deleteReservation(reservationId);
    }

    @Override
    public Reservation getReservation(String reservationId) throws RemoteException {
        return serverModel.getReservation(reservationId);
    }

    @Override
    public ReservationList getReservations() throws RemoteException {
        return serverModel.getReservations();
    }

    @Override
    public void addCustomer(Customer customer) throws RemoteException {
        try {
            serverModel.addCustomer(customer.getUsername(), customer.getPassword(), customer.getFirstName(), customer.getLastName(), customer.getBirthDate());
            System.out.println("Successfully added customer");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String username) throws RemoteException {
        serverModel.deleteCustomer(username);
    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return serverModel.getCustomer(username);
    }

    @Override
    public CustomerList getCustomers() throws RemoteException {
        return serverModel.getCustomers();
    }

    @Override
    public void updateReservationList(ReservationList reservations) throws RemoteException {
        fireUpdateReservationList(reservations);
    }

}
