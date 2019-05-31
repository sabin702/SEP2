package Client;

import CustomerClient.CustomerClient;
import Employee_Client.EmployeeClient;
import Employee_Client.EmployeeClientImpl;
import Model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewHandler;
import viewmodel.ViewModelProvider;

public class EmployeeMain extends Application {
    public void start(Stage stage) throws Exception {
        /*EmployeeModel em = new EmployeeModelImpl();
        CustomerModel cm = new CustomerModelImpl();
        Client client = new ClientImpl(cm, em);
        ViewModelProvider vmp = new ViewModelProvider(cm, em);
        ViewHandler vh = new ViewHandler(stage,vmp);
        vh.startEmployee();*/
        ClientProvider clientProvider = new ClientProvider();
        ModelProvider mp = new ModelProvider(clientProvider);
        ViewModelProvider vmp = new ViewModelProvider(mp);
        ViewHandler vh = new ViewHandler(stage,vmp);
        vh.startEmployee();
    }
}
