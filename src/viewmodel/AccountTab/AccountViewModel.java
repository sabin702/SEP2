package viewmodel.AccountTab;

import DataModel.Customer;
import Model.CustomerModel;
import view.ViewHandler;

import java.io.IOException;
import java.rmi.RemoteException;

public class AccountViewModel {
    private ViewHandler viewHandler;
    private CustomerModel cm;
    private String userName;

    public AccountViewModel(ViewHandler viewHandler, CustomerModel cm){
        this.viewHandler = viewHandler;
        this.cm = cm;
    }

    public void openCreateAccountAndLogin() throws IOException {
        viewHandler.openCreateAccountAndLogIn();
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUsername(){
        return userName;
    }

    public void editCustomer(String username, String firstName, String lastName, String password) throws RemoteException {
        cm.editCustomer(username, firstName, lastName, password);
    }

    public Customer getCustomer(String userName) throws RemoteException {
        return cm.getCustomer(userName);
    }


}
