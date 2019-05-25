package Employee_Client;

import DataModel.Customer;
import Model.CustomerModel;

import java.rmi.RemoteException;
import java.util.Date;

public interface Client {

    void addCarToDatabase(String registration, String make, int mileage, String color, int productionYear, int availability);

    void deleteCar(String carRegNo) throws RemoteException;

    void getCars();

    void addReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status);

    void deleteReservation(String reservationId) throws RemoteException;

    void addCustomer(Customer customer);

    CustomerModel getModel();

}
