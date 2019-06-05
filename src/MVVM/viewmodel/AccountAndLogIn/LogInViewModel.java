package MVVM.viewmodel.AccountAndLogIn;

import MVVM.Model.Customer.CustomerModel;
import MVVM.view.ViewHandler;

import java.io.IOException;
import java.rmi.RemoteException; 

public class LogInViewModel {
    private ViewHandler viewHandler;
    private CustomerModel model;
    private String userName;

    public LogInViewModel (ViewHandler viewHandler, CustomerModel model){
        this.viewHandler = viewHandler;
        this.model = model;
    }
    public void openCustomerTabPane() throws IOException {
        viewHandler.openCustomerTabPane();
    }

    public boolean logIn(String username, String password) throws RemoteException {
        if(model.logIn(username, password)){
            userName = username;
            return true;
        }
        return false;
    }

    public String getUsername(){
        return userName;
    }
    public void openEmptyTextFields() {
        viewHandler.openEmptyTextFields();
    }


    public void openLogInWelcome() {
        viewHandler.openLogInWelcome();
    }

    public void openCreateAccountAndLogIn() throws IOException {
        viewHandler.openCreateAccountAndLogIn();
    }

    public void openWrongUsernamePassword() {
        viewHandler.openWrongUsernamePassword();
    }
}