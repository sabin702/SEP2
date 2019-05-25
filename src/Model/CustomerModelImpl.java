package Model;

import DataModel.Customer;
import DataModel.ReservationList;
import server.IServerModel;
import server.ServerModel;

import java.rmi.RemoteException;

public class CustomerModelImpl implements CustomerModel {

    private IServerModel serverModel;

    public CustomerModelImpl() throws RemoteException {
        serverModel = new ServerModel();
    }

    @Override
    public void createAccount(Customer customer) {
        try {
            serverModel.addCustomer(customer.getUsername(), customer.getPassword(), customer.getFirstName(), customer.getLastName(), customer.getBirthDate());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logIn(String username, String password) {

    }

    @Override
    public void makeReservation() {

    }

    @Override
    public void deleteReservation() {

    }

    @Override
    public void changeUserData() {

    }

    @Override
    public ReservationList viewReservations() {
        return null;
    }
}
