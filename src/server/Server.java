package server;

import database.CarsDatabaseConnection.CarsDAO;
import database.CarsDatabaseConnection.CarsDAOImpl;
import database.CustomersDatabaseConnections.CustomersDAO;
import database.CustomersDatabaseConnections.CustomersDAOImpl;
import database.DatabaseConnection;
import database.ReservationDatabaseConnection.ReservationsDAO;
import database.ReservationDatabaseConnection.ReservationsDAOImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args){

        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            DatabaseConnection database = new DatabaseConnection();
            CarsDAO carsDAO = new CarsDAOImpl(database);
            CustomersDAO customersDAO = new CustomersDAOImpl(database);
            ReservationsDAO reservationsDAO = new ReservationsDAOImpl(database);
            IServerModel serverModel = new ServerModel(carsDAO, customersDAO, reservationsDAO);
            registry.bind("server", serverModel);

            System.out.println("Server has been started!");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }


    }

}
