package Employee_Client;

import DataModel.*;
import Model.CustomerModel;
import Model.EmployeeModel;
import server.IServerModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EmployeeClientImpl implements EmployeeClient{

    IServerModel serverModel;
    CarList cars;
    EmployeeModel model;

    public EmployeeClientImpl(EmployeeModel model) throws RemoteException, NotBoundException {
        this.model = model;
        model.setClient(this);
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        serverModel = (IServerModel) registry.lookup("servers");
        cars = new CarList();
    }

    @Override
    public void addCar(String registration, String make, int mileage, String color, int productionYear, int availability) throws RemoteException {

    }

    @Override
    public void deleteCar(String carRegistrationNumber) throws RemoteException {

    }

    @Override
    public Car getCar(String regisytrationNumber) {
        return null;
    }

    @Override
    public CarList getCars() throws RemoteException {
        return null;
    }

    @Override
    public void deleteReservation(String reservationId) throws RemoteException {

    }

    @Override
    public Reservation getReservation(String registrationId) {
        return null;
    }

    @Override
    public ReservationList getReservations() throws RemoteException {
        return null;
    }

    @Override
    public void deleteCustomer(String username) {

    }

    @Override
    public Customer getCustomer(String username) {
        return null;
    }

    @Override
    public CustomerList getCustomers() {
        return null;
    }
}
