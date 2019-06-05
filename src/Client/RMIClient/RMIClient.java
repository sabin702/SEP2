package Client.RMIClient;

import shared.DataModel.*;
import server.IServerModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient  implements IRMIClient{

   private IServerModel serverModel;
   private PropertyChangeSupport changeSupport;
   private String userName;


    public RMIClient() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        serverModel = (IServerModel) registry.lookup("server");
        changeSupport = new PropertyChangeSupport(this);
        serverModel.addClient(this);
    }

    @Override
    public boolean logIn(String username, String password) throws RemoteException{
        try {
            if(serverModel.logIn(username, password, this)){
                userName = username;
                return true;
            }

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
    public void approveReservation(String reservationID) throws RemoteException {
        serverModel.approveReservation(reservationID);
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
    public ReservationList getCustomerReservations() throws RemoteException {
        return serverModel.getCustomerReservations(userName);
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
    public void editCustomer(String username, String firstName, String lastName, String password) throws RemoteException {
        serverModel.editCustomer(username, firstName, lastName, password);
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
    public void addListener(String event, PropertyChangeListener listener) throws RemoteException {
        changeSupport.addPropertyChangeListener(event,listener);
    }

    @Override
    public void fireUpdateReservations() throws RemoteException {
        System.out.println("add property fired");
        ReservationList reservations = getReservations();
        changeSupport.firePropertyChange("ReservationsUpdated",null, reservations);
    }

    @Override
    public void fireUpdateUsers() throws RemoteException {
        CustomerList customers = getCustomers();
        changeSupport.firePropertyChange("CustomersUpdated",null,customers);
    }

    @Override
    public void fireUpdateCars() throws RemoteException {
        CarList cars = getCars();
        changeSupport.firePropertyChange("CarsUpdated",null,cars);
    }

    @Override
    public void fireUpdateCustomerReservations() throws RemoteException {
        ReservationList reservations = getCustomerReservations();
        changeSupport.firePropertyChange("CustomerReservationsUpdated", null, reservations);
    }


}
