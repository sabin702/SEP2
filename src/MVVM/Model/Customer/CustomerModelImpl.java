package MVVM.Model.Customer;

import Client.CustomerClient.CustomerClient;
import shared.DataModel.CarList;
import shared.DataModel.Customer;
import shared.DataModel.Reservation;
import shared.DataModel.ReservationList;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CustomerModelImpl implements CustomerModel, Serializable {

    private CustomerClient client;

    @Override
    public void setClient(CustomerClient client) {
        this.client = client;
    }

    @Override
    public void createAccount(String username, String password, String firstName, String lastName, Date dateOfBirth) {
        try {
            Customer customer = new Customer(username, password, firstName, lastName, dateOfBirth);
            client.addCustomer(customer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCustomer(String username, String firstName, String lastName, String password) throws RemoteException {
        client.editCustomer(username, firstName, lastName, password);
    }

    @Override
    public Customer getCustomer(String username) throws RemoteException {
        return client.getCustomer(username);
    }

    @Override
    public boolean logIn(String username, String password) {
        try {
            return client.logIn(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void makeReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException {
        Reservation reservation = new Reservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName, age, price, insurance, status);
        client.addReservation(reservation);
    }

    @Override
    public void deleteReservation(String reservationId) throws RemoteException {
        client.deleteReservation(reservationId);
    }

    @Override
    public Reservation getReservation(String reservationId) throws RemoteException {
        return client.getReservation(reservationId);
    }

    @Override
    public ReservationList viewReservations() throws RemoteException {
        return client.getReservations();
    }

    @Override
    public ReservationList getCustomerReservations() throws RemoteException {
        return client.getCustomerReservations();
    }

    @Override
    public CarList getCars() throws RemoteException {
        return client.getCars();
    }

    public int getNumberOfDays(Date date1, Date date2){
        long difference = Math.abs(date2.getTime() - date1.getTime());
        int days = (int) (difference / (1000 * 60 * 60 * 24));
        return days;
    }

    @Override
    public int calculateTotalPrice(String insuranceType, LocalDate localDate1, LocalDate localDate2, int carPrice, int navPrice, int csPrice) {
        int insurancePrice  = 0;
        if(insuranceType.equals("Basic (25 DKK/day)"))
            insurancePrice = 25;
        else if(insuranceType.equals("Medium (50 DKK/day)"))
            insurancePrice =  50;
        else if(insuranceType.equals("Full Coverage (100 DKK/day)"))
            insurancePrice =  100;
        int price = insurancePrice;
        Date dateFrom = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dateTo = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("Days: " + getNumberOfDays(dateFrom, dateTo));

        if (dateFrom.equals(null) || dateTo.equals(null))
            price = (carPrice + navPrice + csPrice + insurancePrice);
        else if (dateFrom.equals(null) && dateTo.equals(null))
            price = (carPrice + navPrice + csPrice + insurancePrice);
        else
            price = (carPrice + navPrice + csPrice + insurancePrice) * getNumberOfDays(dateFrom, dateTo);

        return price;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) throws RemoteException {
        client.addListener(eventName, listener);
    }


}
