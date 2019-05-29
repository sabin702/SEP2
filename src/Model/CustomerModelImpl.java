package Model;

import DataModel.Customer;
import DataModel.ReservationList;
import Employee_Client.Client;
import Employee_Client.CustomerClient;

import java.rmi.RemoteException;
import java.util.Date;

public class CustomerModelImpl implements CustomerModel {

    private CustomerClient client;

    public CustomerModelImpl()  {
    }

    @Override
    public void setClient(CustomerClient client) {
        this.client = client;
    }

    @Override
    public void createAccount(String username, String password, String firstName, String lastName, Date dateOfBirth) {
        try {
            Customer customer = new Customer(username, password, firstName, lastName, dateOfBirth);
            client.addCustomer(customer);
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
    public ReservationList viewReservations() throws RemoteException {
        return client.getReservations();
    }
}
