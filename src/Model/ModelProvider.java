package Model;

import Client.ClientProvider;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelProvider {

    private CustomerModel cm;
    private EmployeeModel  em;
    private ClientProvider clientProvider;

    public ModelProvider(ClientProvider clientProvider) throws RemoteException, NotBoundException {
        cm = new CustomerModelImpl();
        em = new EmployeeModelImpl();
        this.clientProvider = clientProvider;
        cm.setClient(clientProvider.getClient());
        em.setClient(clientProvider.getClient());
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
