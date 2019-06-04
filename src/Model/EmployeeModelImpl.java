package Model;

import Client.Client;
import DataModel.*;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;

public class EmployeeModelImpl implements EmployeeModel, Serializable{

    private Client client;
    private CarList cars;
    private ReservationList reservations;

    public EmployeeModelImpl() {

    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void approveReservation(String reservationID) throws RemoteException {
        client.approveReservation(reservationID);
    }

    @Override
    public void deleteReservation(String reservationID) throws RemoteException {
        Reservation reservation = client.getReservation(reservationID);
        client.deleteReservation(reservationID);
        //changeSupport.firePropertyChange("ReservationDeleted", null, reservation);
    }

    @Override
    public void addCar(String registrationNumber,String make,int mileage,String color,int productionYear,String category,int price, int availability) throws RemoteException {
        Car car = new Car(registrationNumber,make,mileage,color,productionYear,category,price,availability);
        client.addCar(car);


    }

    @Override
    public void deleteCar(String carRegNo) throws RemoteException {
        Car car = client.getCar(carRegNo);
        client.deleteCar(carRegNo);

    }

    @Override
    public void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException {
        Car car1 = client.getCar(registrationNumber);
        client.editCar(registrationNumber, mileage, price, availability);
        Car car2 = client.getCar(registrationNumber);
        //changeSupport.firePropertyChange("CarEdited", car1, car2);
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
    public ReservationList updateReservations() throws RemoteException {
        return client.updateReservations();
    }

    @Override
    public void fireUpdateReservations() throws RemoteException {
        /*client.fireUpdateReservations();*/
    }

    @Override
    public void fireUpdateUsers() throws RemoteException {
        client.fireUpdateUsers();
    }

    @Override
    public void fireUpdateCars() throws RemoteException {
        client.fireUpdateCars();
    }


    @Override
    public void addListener(String eventName, PropertyChangeListener listener) throws RemoteException {

        client.addListener(eventName, listener);


    }
}
