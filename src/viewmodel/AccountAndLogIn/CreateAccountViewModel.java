package viewmodel.AccountAndLogIn;

import DataModel.Customer;
import Model.CustomerModel;
import Model.CustomerModelImpl;
import view.ViewHandler;

import java.io.IOException;
import java.rmi.RemoteException;

public class CreateAccountViewModel {
    private ViewHandler viewHandler;
    private CustomerModel model;
    private Customer customer;

    public CreateAccountViewModel(ViewHandler viewHandler, CustomerModel model){
        this.viewHandler = viewHandler;
        this.model = model;
    }
    public void openCreateAccountAndLogIn() throws IOException {
        viewHandler.openCreateAccountAndLogIn();
    }

    public void createAccount(Customer customer){
        model.createAccount(customer);
    }
}
