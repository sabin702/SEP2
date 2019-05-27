package Employee_Client;

import Model.CustomerModel;
import Model.CustomerModelImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewHandler;
import viewmodel.ViewModelProvider;


public class CustomerMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        CustomerModel cm = new CustomerModelImpl();
        CustomerClient client = new CustomerClientImpl(cm);
        ViewModelProvider vmp = new ViewModelProvider(cm);
        ViewHandler vh = new ViewHandler(stage,vmp);
        vh.startCustomer();
    }
}
