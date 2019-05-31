package viewmodel.AccountAndLogIn;

import Model.CustomerModel;
import view.ViewHandler;

import java.io.IOException;

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

    public boolean logIn(String username, String password){
        if(model.logIn(username, password)){
            userName = username;
            return true;
        }
        return false;
    }

    public String getUsername(){
        return userName;
    }


}
