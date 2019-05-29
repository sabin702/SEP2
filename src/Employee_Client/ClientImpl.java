package Employee_Client;

import DataModel.Car;
import DataModel.CarList;
import DataModel.Customer;
import Model.CustomerModel;
import server.IServerModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class ClientImpl implements Client {

    IServerModel serverModel;
    CarList cars;
    CustomerModel model;

    public ClientImpl(CustomerModel model) throws RemoteException, NotBoundException {
        this.model = model;
        //model.setClient(this);
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        serverModel = (IServerModel) registry.lookup("servers");
        cars = new CarList();
    }


    public void addCarToDatabase(String registration, String make, int mileage, String color, int productionYear, String category, int price, int availability){
        try {
            serverModel.addCar(new Car(registration, make, mileage, color, productionYear, category, price, availability));
            System.out.println("Successfully added car!");
        } catch (RemoteException e) {
            System.out.println("here client");
            e.printStackTrace();
        }
    }

    public void deleteCar(String carRegNo) throws RemoteException {
        serverModel.deleteCar(carRegNo);
    }

    public void getCars(){
        try {
            cars  = serverModel.getCars();

            //Display values
            for (int i = 0; i < cars.size(); i++) {
                System.out.println(cars.getCar(i));
            }

            System.out.println("Successfully returned cars");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status){
        try {
            serverModel.addReservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);
            System.out.println("Successfully added reservation");
        } catch (RemoteException e) {
            System.out.println("Add reservation issue");
            e.printStackTrace();
        }
    }

    public void deleteReservation(String reservationId) throws RemoteException {
        serverModel.deleteReservation(reservationId);
    }

    public void addCustomer(Customer customer){
        try {
            serverModel.addCustomer(customer.getUsername(), customer.getPassword(), customer.getFirstName(), customer.getLastName(), customer.getBirthDate());
            System.out.println("Successfully added customer");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void getCustomers() throws RemoteException {
        for (int i = 0; i < serverModel.getCustomers().size(); i++) {
            System.out.println(serverModel.getCustomers().getCustomer(i));
        }
    }

    public CustomerModel getModel(){
        return model;
    }
}
