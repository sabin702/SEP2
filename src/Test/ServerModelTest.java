package Test;

import Client.Client;
import Client.IRMIClient;
import Client.RMIClient;
import DataModel.Car;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import server.ServerModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ServerModelTest {

    ServerModel serverModel;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void start(){
        try {
            serverModel = new ServerModel();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void logIn() {
        exception.expect(RemoteException.class);
        exception.expect(NotBoundException.class);
        String userName = "polish";
        String password = "pass";
        String firstName = "Carl";
        String lastName = "Car";
        Date birthDate = new GregorianCalendar(1990, Calendar.FEBRUARY, 07).getTime();



        try {
            serverModel.addCustomer(userName, password, firstName, lastName, birthDate);
            IRMIClient client = new RMIClient();

            assertEquals(true, serverModel.logIn(userName, password, client));
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void addCar() throws RemoteException {
        Car car = new Car("A12345", "Afdff", 10, "red", 2000, "Small car", 100, 0);
        serverModel.addCar(car);
    }

    @org.junit.Test
    public void deleteCar() throws RemoteException {
        Car car = new Car("A12345", "Afdff", 10, "red", 2000, "Small car", 100, 0);
        serverModel.addCar(car);
        serverModel.deleteCar(car.getRegistrationNumber());
    }

    @org.junit.Test
    public void editCar() {
        serverModel.editCar();
    }

    @org.junit.Test
    public void getCar() {
    }

    @org.junit.Test
    public void getCars() {
    }

    @org.junit.Test
    public void addReservation() {
    }

    @org.junit.Test
    public void deleteReservation() {
    }

    @org.junit.Test
    public void approveReservation() {
    }

    @org.junit.Test
    public void getReservation() {
    }

    @org.junit.Test
    public void getReservations() {
    }

    @org.junit.Test
    public void addCustomer() {
    }

    @org.junit.Test
    public void deleteCustomer() {
    }

    @org.junit.Test
    public void editCustomer() {
    }

    @org.junit.Test
    public void getCustomer() {
    }

    @org.junit.Test
    public void getCustomers() {
    }

    @org.junit.Test
    public void callClientUpdateReservation() {
    }

    @org.junit.Test
    public void addClient() {
    }

    @org.junit.Test
    public void callClientUpdateUsers() {
    }

    @org.junit.Test
    public void callClientUpdateCars() {
    }
}