package Model;

import DataModel.*;
import Client.Client;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;

public class EmployeeModelImpl implements EmployeeModel{

    private Client client;
    private PropertyChangeSupport changeSupport;
    private CarList cars;
    private ReservationList reservations;

    public EmployeeModelImpl() {
        changeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
        try {
            cars = client.getCars();
            reservations = client.getReservations();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void approveReservatiokn(String reservationID) {

    }

    @Override
    public void deleteReservation(String reservationID) throws RemoteException {
        Reservation reservation = client.getReservation(reservationID);
        client.deleteReservation(reservationID);
        changeSupport.firePropertyChange("ReservationDeleted", null, reservation);
    }

    @Override
    public void addCar(String registrationNumber,String make,int mileage,String color,int productionYear,String category,int price, int availability) throws RemoteException {
        Car car = new Car(registrationNumber,make,mileage,color,productionYear,category,price,availability);
        client.addCar(car);
        cars.addCar(car);
        changeSupport.firePropertyChange("CarAdded", null, car);
    }

    @Override
    public void deleteCar(String carRegNo) throws RemoteException {
        Car car = client.getCar(carRegNo);
        client.deleteCar(carRegNo);
        changeSupport.firePropertyChange("CarDeleted", null, car);
    }

    @Override
    public void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException {
        Car car1 = client.getCar(registrationNumber);
        client.editCar(registrationNumber, mileage, price, availability);
        Car car2 = client.getCar(registrationNumber);
        changeSupport.firePropertyChange("CarEdited", car1, car2);
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
    public CustomerList viewUsers() throws RemoteException {
        return client.getCustomers();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(eventName, listener);
    }
}
