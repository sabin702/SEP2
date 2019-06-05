package Client;

import Client.CustomerClient.*;
import Client.EmployeeClient.EmployeeClient;
import Client.EmployeeClient.EmployeeClientImpl;
import Client.RMIClient.IRMIClient;
import Client.RMIClient.RMIClient;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientProvider implements Serializable {

    private CustomerClient customerClient;
    private EmployeeClient employeeClient;
    private IRMIClient rmiClient;

    public ClientProvider() throws RemoteException, NotBoundException {

            rmiClient = new RMIClient();
            customerClient = new CustomerClientImpl(rmiClient);
            employeeClient = new EmployeeClientImpl(rmiClient);
    }

    public CustomerClient getCustomerClient(){
        return customerClient;
    }

    public EmployeeClient getEmployeeClient(){
        return employeeClient;
    }

    public IRMIClient getRMIClient(){
        return rmiClient;
    }
}
