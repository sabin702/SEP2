package Client;

import DataModel.*;
import Model.CustomerModel;
import Model.EmployeeModel;
import server.IServerModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientImpl {

    CarList cars;
    RMIClient client;

    public ClientImpl(RMIClient client){
        cars = new CarList();
        this.client = client;
    }

}
