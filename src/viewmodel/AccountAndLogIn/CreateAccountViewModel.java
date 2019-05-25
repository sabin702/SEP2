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

    public void createAccount(Customer customer){
        model.createAccount(customer);
    }
}
