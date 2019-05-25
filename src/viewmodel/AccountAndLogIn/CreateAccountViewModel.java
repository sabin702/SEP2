package viewmodel.AccountAndLogIn;

import DataModel.Customer;
import Employee_Client.Client;
import Model.CustomerModel;
import Model.CustomerModelImpl;
import server.ServerModel;
import view.CreateAccountAndLogIn.CreateAccountView;
import view.ViewHandler;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

public class CreateAccountViewModel {
    private ViewHandler viewHandler;
    private CustomerModel model;
    private Customer customer;

    public CreateAccountViewModel(ViewHandler viewHandler){
        this.viewHandler = viewHandler;
        try {
            model = new CustomerModelImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void openCreateAccountAndLogIn() throws IOException {
        viewHandler.openCreateAccountAndLogIn();
    }

    public void createAccount(String firstName, String lastName, Date dateOfBirth, String username, String password){
        model.createAccount(new Customer(username, password, firstName, lastName, dateOfBirth));
    }
}
