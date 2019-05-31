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
    CustomerModel cm;

    public EmployeeClientImpl(EmployeeModel model, CustomerModel cm) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        serverModel = (IServerModel) registry.lookup("servers");
        cars = new CarList();
        this.model = model;
        this.cm = cm;
        //model.setClient(this);
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
    public void deleteReservation(String reservationId) throws RemoteException {
        serverModel.deleteReservation(reservationId);
    }

    @Override
    public Reservation getReservation(String reservationId) throws RemoteException {
        return serverModel.getReservation(reservationId);
    }

    @Override
    public ReservationList getReservations() throws RemoteException {
        if(serverModel.getReservations().getReservation(0) == null)
            System.out.println("Null");
        else
            System.out.println("Not null");
        return serverModel.getReservations();
    }

    @Override
    public void deleteCustomer(String username) {

    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return serverModel.getCustomer(username);
    }

    @Override
    public CustomerList getCustomers() {
        return getCustomers();
    }
}
