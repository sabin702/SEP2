package RunClients.Employee;


import Client.ClientProvider;
import MVVM.Model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import MVVM.view.ViewHandler;
import MVVM.viewmodel.VMProvider;

public class EmployeeMain extends Application {
    public void start(Stage stage) throws Exception {
        ClientProvider clientProvider = new ClientProvider();
        ModelProvider mp = new ModelProvider(clientProvider);
        VMProvider vmp = new VMProvider(mp);
        ViewHandler vh = new ViewHandler(stage,vmp);
        vh.startEmployee();
    }
}
