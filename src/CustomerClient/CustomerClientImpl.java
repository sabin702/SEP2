package CustomerClient;

import DataModel.*;
import Model.CustomerModel;
import server.IServerModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CustomerClientImpl implements CustomerClient{

    IServerModel serverModel;
    CarList cars;
    CustomerModel model;

    public CustomerClientImpl(CustomerModel model) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        serverModel = (IServerModel) registry.lookup("servers");
        cars = new CarList();
        this.model = model;
        //model.setClient(this);
    }

    @Override
    public Car getCar(String registrationNumber) {
        return null;
    }

    @Override
    public CarList getCars() throws RemoteException {
        try {
            cars  = serverModel.getCars();

            //Display values
            for (int i = 0; i < cars.size(); i++) {
                System.out.println(cars.getCar(i));
            }

            System.out.println("Successfully returned cars");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public void addReservation(Reservation reservation) throws RemoteException {
        try {
            serverModel.addReservation(reservation.getReservationId(), reservation.getCarRegNo(), reservation.getUsername(), reservation.getDateFromObject(), reservation.getDateToObject(), reservation.getNavigation(), reservation.getChildseat(), reservation.getFirstName(), reservation.getLastName(), reservation.getAge(), reservation.getPrice(), reservation.getInsurance(), reservation.getStatus());
            System.out.println("Successfully added reservation");
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
    public Reservation getReservation(String registrationId) throws RemoteException {
        return serverModel.getReservation(registrationId);
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
    public void deleteCustomer(String username) {

    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return serverModel.getCustomer(username);
    }

    @Override
    public CustomerList getCustomers() throws RemoteException {
        return serverModel.getCustomers();
    }
}
