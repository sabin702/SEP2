package Client.EmployeeClient;

import Client.*;
import MVVM.Model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import MVVM.view.ViewHandler;
import MVVM.viewmodel.ViewModelProvider;

public class EmployeeMain extends Application {
    public void start(Stage stage) throws Exception {
        ClientProvider clientProvider = new ClientProvider();
        ModelProvider mp = new ModelProvider(clientProvider);
        ViewModelProvider vmp = new ViewModelProvider(mp);
        ViewHandler vh = new ViewHandler(stage,vmp);
        vh.startEmployee();
    }
}
