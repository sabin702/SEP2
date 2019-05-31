package viewmodel.UsersTab;

import DataModel.Car;
import DataModel.Customer;
import Model.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.ViewHandler;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;

public class UsersViewModel {

    private EmployeeModel model;
    private ObservableList<Customer> customers;

    public UsersViewModel(EmployeeModel model){
        customers = FXCollections.observableArrayList();

        this.model = model;

        getCustomers();
    }

    private void getCustomers() {
        try {
            for (int i = 0; i < model.viewUsers().size(); i++) {
                Customer temp = model.viewUsers().getCustomer(i);
                customers.add(temp);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void customerAdded(PropertyChangeEvent evt){
        customers.add((Customer) evt.getNewValue());
    }
}
