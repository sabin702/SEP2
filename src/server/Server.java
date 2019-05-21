package server;

import Employee_Client.REmployee;
import Employee_Client.RMIEmployee;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            IServerModel serverModel = new ServerModel();
            registry.bind("servers", serverModel);

            System.out.println("Server has been started!");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

}
