package Model;

import Client.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import Client.ClientProvider;

public class ModelProvider {

    private CustomerModel cm;
    private EmployeeModel  em;
    private ClientProvider clientProvider;

    public ModelProvider(ClientProvider clientProvider) {
        cm = new CustomerModelImpl();
        em = new EmployeeModelImpl();
        this.clientProvider = clientProvider;
    }

    public CustomerModel getCustomerModel() {
        if(cm == null) {
           cm = new CustomerModelImpl();
        }
        return cm;
    }

    public EmployeeModel getEmployeeModel() {
        if(em == null) {
            em = new EmployeeModelImpl();
        }
        return em;
    }
}
