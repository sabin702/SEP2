package viewmodel.UsersTab;

import DataModel.Car;
import DataModel.Customer;
import DataModel.CustomerList;
import Model.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.ViewHandler;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;

public class UsersViewModel {

    private EmployeeModel model;
    private ObservableList<Customer> customers;

    public UsersViewModel(EmployeeModel model) throws RemoteException{
        customers = FXCollections.observableArrayList();

        this.model = model;

        getCustomers();

        model.addListener("CustomersUpdated",this::updateCustomersList);
    }

    private void updateCustomersList(PropertyChangeEvent propertyChangeEvent) {
        customers.clear();

        System.out.println("updated");

        CustomerList reservationList = (CustomerList) propertyChangeEvent.getNewValue();

        for (int i = 0; i <reservationList.size(); i++) {
            Customer temp = reservationList.getCustomer(i);
            customers.add(temp);
        }
    }

    private void getCustomers() {
        try {
            for (int i = 0; i < model.getCustomers().size(); i++) {
                Customer temp = model.getCustomers().getCustomer(i);
                customers.add(temp);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void customerAdded(PropertyChangeEvent evt){
        customers.add((Customer) evt.getNewValue());
    }

    public ObservableList<Customer> getCustomerList() {
        return customers;
    }
}
