package Test;

import Client.RMIClient.IRMIClient;
import DataModel.*;
import database.CarsDatabaseConnection.CarsDAO;
import database.CarsDatabaseConnection.CarsDAOImpl;
import database.CustomersDatabaseConnections.CustomersDAO;
import database.CustomersDatabaseConnections.CustomersDAOImpl;
import database.ReservationDatabaseConnection.ReservationsDAO;
import database.ReservationDatabaseConnection.ReservationsDAOImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.*;

public class ServerModelTest {

    private CarsDAO carsDAO;
    private CustomersDAO customersDAO;
    private ReservationsDAO reservationsDAO;
    List<IRMIClient> clients;
    private PropertyChangeSupport changeSupport;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void start(){
        carsDAO = new CarsDAOImpl();
        customersDAO = new CustomersDAOImpl();
        reservationsDAO = new ReservationsDAOImpl();
        changeSupport = new PropertyChangeSupport(this);
        clients = new ArrayList<IRMIClient>();
    }

    @org.junit.Test
    public void logIn() {
        exception.expect(SQLException.class);
        String userName = "user123";
        String password = "pass123";
        String firstName = "userrrrrr";
        String lastName = "userlast";
        Date birthDate = new GregorianCalendar(1990, Calendar.FEBRUARY, 07).getTime();

        boolean loggedin = false;


        customersDAO.addCustomer(userName, password, firstName, lastName, birthDate);

        if(customersDAO.getCustomer(userName) != null){
            if (customersDAO.getCustomer(userName).getUsername().equals(userName) && customersDAO.getCustomer(userName).getPassword().equals(password))
                loggedin = true;
        }
        assertEquals(true, loggedin);

    }

    @org.junit.Test
    public void addCar() throws RemoteException {
        exception.expect(SQLException.class);
        Car car = new Car("Z12345", "Afdff", 10, "red", 2000, "Small car", 100, 0);
        carsDAO.addCar(car);
    }

    @org.junit.Test
    public void editCar() throws RemoteException {
        exception.expect(SQLException.class);
        carsDAO.editCar("Z12345", 20, 500, 1);

        boolean sameCar = false;

        if((carsDAO.getCar("Z12345").getMileage() == 20) && (carsDAO.getCar("Z12345").getPrice() == 500) && (carsDAO.getCar("Z12345").getAvailability() == 1))
            sameCar = true;

        assertEquals(true, sameCar);

    }

    @org.junit.Test
    public void getCar() {
        exception.expect(SQLException.class);
        Car car = carsDAO.getCar("Z12345");
        assertEquals(true, carsDAO.getCar("Z12345").equals(car));
    }

    @org.junit.Test
    public void deleteCar() throws RemoteException {
        exception.expect(SQLException.class);
        Car car = new Car("Z12345", "Afdff", 20, "red", 2000, "Small car", 500, 1);
        carsDAO.deleteCar(car.getRegistrationNumber());
    }

    @org.junit.Test
    public void getCars() {
        exception.expect(SQLException.class);
        CarList cars = carsDAO.getCars();

        assertEquals(true, cars.size() == carsDAO.getCars().size());
    }

    @org.junit.Test
    public void addReservation() {
        exception.expect(SQLException.class);
        Car car = new Car("Z12345", "CarMake", 100, "blue", 2015, "Small car", 768, 1);
        carsDAO.addCar(car);
        Date birthDate = new GregorianCalendar(1990, Calendar.FEBRUARY, 07).getTime();
        Date dateFrom = new GregorianCalendar(2019, Calendar.JULY, 10).getTime();
        Date dateTo = new GregorianCalendar(2019, Calendar.JULY, 20).getTime();
        Customer customer = new Customer("user9504", "password356", "UserUser", "UserLast", birthDate);
        Reservation reservation = new Reservation("R00001", car.getRegistrationNumber(), customer.getUsername(), dateFrom, dateTo, 1, 1, customer.getFirstName(), customer.getLastName(), customer.getAge(), 1000, 1, 1);
    }

    @org.junit.Test
    public void approveReservation() {
        exception.expect(SQLException.class);
        reservationsDAO.approveReservation("R00001");
        assertEquals(1, reservationsDAO.getReservation("R00001").getStatus());
    }

    @org.junit.Test
    public void getReservation() {
        exception.expect(SQLException.class);
        reservationsDAO.getReservation("R00001");
    }

    @org.junit.Test
    public void getCustomerReservations() {
        exception.expect(SQLException.class);
        ReservationList reservations = reservationsDAO.getCustomerReservations("user9504");
        assertEquals(true, reservations.size() == reservationsDAO.getReservations().size());
    }

    @org.junit.Test
    public void deleteReservation() {
        exception.expect(SQLException.class);
        reservationsDAO.deleteReservation("R00001");
        reservationsDAO.getReservation("R00001");
    }

    @org.junit.Test
    public void getReservations() {
        exception.expect(SQLException.class);
        ReservationList reservations = reservationsDAO.getReservations();
        assertEquals(true, reservations.size() == reservationsDAO.getReservations().size());
    }

    @org.junit.Test
    public void addCustomer() {
        exception.expect(SQLException.class);
        Date birthDate = new GregorianCalendar(1990, Calendar.FEBRUARY, 07).getTime();
        Customer customer = new Customer("someUser", "somepass", "UserUser", "UserLast", birthDate);
        customersDAO.addCustomer(customer.getUsername(), customer.getPassword(), customer.getFirstName(), customer.getLastName(), customer.getBirthDate());
        assertEquals(true, customersDAO.getCustomer(customer.getUsername()).getUsername().equals(customer.getUsername()));
    }

    @org.junit.Test
    public void editCustomer() {
        exception.expect(SQLException.class);
        customersDAO.editCustomer("someUser", "otherFirtsName", "otherLastName", "otherpass");
        assertEquals(true, customersDAO.getCustomer("someUser").getFirstName().equals("otherFirstName"));
    }

    @org.junit.Test
    public void getCustomer() {
        exception.expect(SQLException.class);
        Customer customer = customersDAO.getCustomer("someUser");
        assertEquals(true, customersDAO.getCustomer("someUser").getUsername().equals(customer.getUsername()));
    }

    @org.junit.Test
    public void deleteCustomer() {
        exception.expect(SQLException.class);
        customersDAO.deleteCustomer("someUser");
    }

    @org.junit.Test
    public void getCustomers() {
        exception.expect(SQLException.class);
        CustomerList customers = customersDAO.getCustomers();
        assertEquals(true, customersDAO.getCustomers().size() == customers.size());
    }

    @org.junit.Test
    public void callClientUpdateReservation() {

    }

    @org.junit.Test
    public void addClient() {
        exception.expect(SQLException.class);
    }

    @org.junit.Test
    public void callClientUpdateUsers() {
    }

    @org.junit.Test
    public void callClientUpdateCars() {
    }
}