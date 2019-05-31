package Client;

import CustomerClient.CustomerClient;
import Model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewHandler;
import viewmodel.ViewModelProvider;

public class StartClient extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ClientProvider clientProvider = new ClientProvider();
        ModelProvider mp = new ModelProvider(clientProvider);
        ViewModelProvider vmp = new ViewModelProvider(mp);
        ViewHandler vh = new ViewHandler(stage,vmp);
        vh.startCustomer();
        vh.startEmployee();

    }
}
