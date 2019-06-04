package database.CustomersDatabaseConnections;

import DataModel.Customer;
import DataModel.CustomerList;

import java.util.Date;

public interface CustomersDAO {

    void addCustomer(String username, String password, String firstName, String lastName, Date dateOfBirth);

    void deleteCustomer(String username);

    void editCustomer(String username, String firstName, String lastName, String password);

    Customer getCustomer(String username);

    CustomerList getCustomers();

    void connectToDatabase();

}
