package viewmodel.AccountAndLogIn;

import DataModel.Customer;
import Model.CustomerModel;
import view.ViewHandler;

import java.io.IOException;
import java.rmi.RemoteException;

public class LogInViewModel {
    private ViewHandler viewHandler;
    private CustomerModel model;

    public LogInViewModel (ViewHandler viewHandler, CustomerModel model){
        this.viewHandler = viewHandler;
        this.model = model;
    }
    public void openCustomerTabPane() throws IOException {
        viewHandler.openCustomerTabPane();
    }

    public boolean logIn(String username, String password) throws RemoteException {
        if(model.getCustomer(username) == null) {
            System.out.println("No user found");
            return false;
        }
        else if(model.getCustomer(username).getPassword().equals(password))
            return true;
        else
            return false;
    }


}
