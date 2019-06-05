package MVVM.Model;

import Client.ClientProvider;
import MVVM.Model.Customer.CustomerModel;
import MVVM.Model.Customer.CustomerModelImpl;
import MVVM.Model.Employee.EmployeeModel;
import MVVM.Model.Employee.EmployeeModelImpl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelProvider {

    private CustomerModel cm;
    private EmployeeModel em;
    private ClientProvider clientProvider;

    public ModelProvider(ClientProvider clientProvider) throws RemoteException, NotBoundException {
        cm = new CustomerModelImpl();
        em = new EmployeeModelImpl();
        this.clientProvider = clientProvider;
        cm.setClient(clientProvider.getCustomerClient());
        em.setClient(clientProvider.getEmployeeClient());
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