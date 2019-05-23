package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.CreateAccountAndLogIn.CreateAccountAndLogInView;
import view.CreateAccountAndLogIn.CreateAccountView;
import view.CreateAccountAndLogIn.LogInView;
import view.Tabs.CustomerTabPane.CustomerTabPaneView;
import view.Tabs.EmployeeTabPane.AddCar.AddCarView;
import view.Tabs.EmployeeTabPane.EmployeeTabPaneView;
import viewmodel.ViewModelProvider;

import java.io.IOException;

public class ViewHandler {
    private Stage stage;
    private ViewModelProvider viewModelProvider;

    public ViewHandler(Stage stage, ViewModelProvider vmp) {
        this.stage = stage;
        viewModelProvider = vmp;
        vmp.instantiateViewModels(this);

    }

    public void startEmployee() throws Exception {
        openEmployeeTabPane();
    }
    public void startCustomer() throws Exception{
        openCreateAccountAndLogIn();
    }

    public void openEmployeeTabPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/view/Tabs/EmployeeTabPane/EmployeeTabPane.fxml"));
        Parent root = loader.load();
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EmployeeTabPaneView view = loader.getController();
        view.init(viewModelProvider);

        Scene scene = new Scene(root);

        stage.setTitle("Rent n' Go!");

        stage.setScene(scene);
        stage.show();
    }



    public void openCustomerTabPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/view/Tabs/CustomerTabPane/CustomerTabPane.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomerTabPaneView view = loader.getController();
        view.init(viewModelProvider);

        Scene scene = new Scene(root);

        stage.setTitle("Rent n' Go!");

        stage.setScene(scene);
        stage.show();

    }
    public void openAddCar() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/view/Tabs/EmployeeTabPane/AddCar/AddCar.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AddCarView view = loader.getController();
        view.init(viewModelProvider.getAddCarViewModel());

        Scene scene = new Scene(root);

        stage.setTitle("Add Car");

        stage.setScene(scene);
        stage.show();
    }
    public void openCreateAccountAndLogIn () throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/view/CreateAccountAndLogIn/CreateAccountAndLogIn.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CreateAccountAndLogInView view = loader.getController();
         view.init(viewModelProvider.getCreateAccountAndLogInViewModel());

        Scene scene = new Scene(root);

        stage.setTitle("Creat account or log in");

        stage.setScene(scene);
        stage.show();

    }
    public void openCreateAccount() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/view/CreateAccountAndLogIn/CreateAccount.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CreateAccountView view = loader.getController();
        view.init(viewModelProvider.getCreateAccountViewModel());

        Scene scene = new Scene(root);

        stage.setTitle("Create account");

        stage.setScene(scene);
        stage.show();

    }
    public void openLogIn() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/view/CreateAccountAndLogIn/LogIn.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        LogInView view = loader.getController();
         view.init(viewModelProvider.getLogInViewModel());

        Scene scene = new Scene(root);


        stage.setTitle("Log In");

        stage.setScene(scene);
        stage.show();
    }
}
