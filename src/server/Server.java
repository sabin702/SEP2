package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args){

        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            ServerModel serverModel = new ServerModel();
            registry.bind("server", serverModel);

            System.out.println("Server has been started!");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }


    }

}
