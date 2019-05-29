package Model;

import DataModel.Car;
import DataModel.CustomerList;
import DataModel.Reservation;
import DataModel.ReservationList;
import Employee_Client.EmployeeClient;

import java.rmi.RemoteException;

public class EmployeeModelImpl implements EmployeeModel{

    private EmployeeClient client;

    @Override
    public void setClient(EmployeeClient client) {
        this.client = client;
    }

    @Override
    public void approveReservatiokn(String reservationID) {

    }

    @Override
    public void deleteReservation(String reservationID) {

    }

    @Override
    public void addCar(String registrationNumber,String make,int mileage,String color,int productionYear,String category,int price, int availability) throws RemoteException {
        Car car = new Car(registrationNumber,make,mileage,color,productionYear,category,price,availability);
        client.addCar(car);
    }

    @Override
    public void deletCar(String carID) {

    }

    @Override
    public void editCar() {

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
    public CustomerList viewUsers() {
        return null;
    }
}
