package Model;

import DataModel.Customer;
import DataModel.ReservationList;
import Employee_Client.ClientImpl;
import Employee_Client.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CustomerModelImpl implements CustomerModel {

    private Client client;

    public CustomerModelImpl() throws RemoteException {
        try {
            client = new ClientImpl(this);
        } catch (NotBoundException e) {
            System.out.println("oops");
            e.printStackTrace();
        }
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void createAccount(Customer customer) {
        if(client == null){
            System.out.println("Pointless");
        }


        //serverModel.addCustomer(customer.getUsername(), customer.getPassword(), customer.getFirstName(), customer.getLastName(), customer.getBirthDate());
        client.addCustomer(customer);
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
