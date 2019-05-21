package Employee_Client;

import Employee_Client.REmployee;
import database.ManageDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIEmployee implements REmployee {

    ManageDatabase database;

    public RMIEmployee() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 1099);
    }

    @Override
    public void addCar() {
        System.out.println("Car added successfully!");
        database.addCar("ABCDEF", "Audi", 100, "red", 2019, 1);
    }

    @Override
    public void deleteCar() {
        System.out.println("Car deleted successfully!");
    }
}
