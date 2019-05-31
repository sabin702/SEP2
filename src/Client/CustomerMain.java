package Client;

import CustomerClient.CustomerClient;
import Model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewHandler;
import viewmodel.ViewModelProvider;


public class CustomerMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        /*CustomerModel cm = new CustomerModelImpl();
        EmployeeModel em = new EmployeeModelImpl();
        Client client = new ClientImpl(cm, em);
        ViewModelProvider vmp = new ViewModelProvider(cm);
        ViewHandler vh = new ViewHandler(stage,vmp);
        vh.startCustomer();*/
        ClientProvider clientProvider = new ClientProvider();
        ModelProvider mp = new ModelProvider(clientProvider);
        ViewModelProvider vmp = new ViewModelProvider(mp);
        ViewHandler vh = new ViewHandler(stage,vmp);
        vh.startCustomer();
    }
}
