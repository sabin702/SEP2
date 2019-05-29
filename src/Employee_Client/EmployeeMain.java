package Employee_Client;

import Model.CustomerModel;
import Model.CustomerModelImpl;
import Model.EmployeeModel;
import Model.EmployeeModelImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewHandler;
import viewmodel.ViewModelProvider;

public class EmployeeMain extends Application {
    public void start(Stage stage) throws Exception {
        EmployeeModel em = new EmployeeModelImpl();
        EmployeeClient client = new EmployeeClientImpl(em);
        ViewModelProvider vmp = new ViewModelProvider(em);
        ViewHandler vh = new ViewHandler(stage,vmp);
        vh.startEmployee();
    }
}
