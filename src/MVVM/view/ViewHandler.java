package MVVM.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import MVVM.view.CreateAccountAndLogIn.CreateAccountAndLogInView;
import MVVM.view.CreateAccountAndLogIn.CreateAccountView;
import MVVM.view.CreateAccountAndLogIn.LogInView;
import MVVM.view.Popups.ClosePopUpView;
import MVVM.view.Popups.LogOutReminderView;
import MVVM.view.Tabs.CustomerTabPane.CustomerTabPaneView;
import MVVM.view.Tabs.EmployeeTabPane.EmployeeTabPaneView;
import MVVM.viewmodel.VMProvider;

import java.io.IOException;
import java.io.Serializable;

public class ViewHandler implements Serializable {
    private Stage stage;
    private Stage popUpStage;
    private VMProvider viewModelProvider;

    public ViewHandler(Stage stage, VMProvider vmp) {
        this.stage = stage;
        popUpStage = new Stage();
        viewModelProvider = vmp;
    }

    public void startEmployee() throws Exception {
        openEmployeeTabPane();
    }

    public void startCustomer() throws Exception {
        viewModelProvider.instantiateCreateAccountAndLogInViewModel(this);
        openCreateAccountAndLogIn();
    }

    public void openEmployeeTabPane() throws IOException {
        viewModelProvider.instantiateReservationsViewModel(this);
        viewModelProvider.instantiateCarsViewModel(this);
        viewModelProvider.instantiateUsersViewModel();
        viewModelProvider.instantiateAddCarViewModel(this);
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Tabs/EmployeeTabPane/EmployeeTabPane.fxml"));
        Parent root = null;
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
        viewModelProvider.instantiateMakeReservationViewModel(this);
        viewModelProvider.instantiateViewReservationsViewModel(this);
        viewModelProvider.instantiateAccountViewModel(this);
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Tabs/CustomerTabPane/CustomerTabPane.fxml"));
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

    public void openCreateAccountAndLogIn() throws IOException {

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/CreateAccountAndLogIn/CreateAccountAndLogIn.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CreateAccountAndLogInView view = loader.getController();
        view.init(viewModelProvider.getCreateAccountAndLogInViewModel());
        viewModelProvider.instantiateCreateAccountAndLogInViewModel(this);

        Scene scene = new Scene(root);

        stage.setTitle("Creat account or log in");

        stage.setScene(scene);
        stage.show();

    }

    public void openCreateAccount() throws IOException {
        viewModelProvider.instantiateCreateAccountViewModel(this);
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/CreateAccountAndLogIn/CreateAccount.fxml"));
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
        viewModelProvider.instantiateLogInViewModel(this);
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/CreateAccountAndLogIn/LogIn.fxml"));

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

    public void openEmptyTextFields() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Popups/EmptyTextFields.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        ClosePopUpView view = loader.getController();


        Scene scene = new Scene(root);


        popUpStage.setTitle("Error");

        popUpStage.setScene(scene);
        popUpStage.show();
    }

    public void openLogInWelcome() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Popups/LogInWelcome.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        ClosePopUpView view = loader.getController();


        Scene scene = new Scene(root);


        popUpStage.setTitle("Welcome");

        popUpStage.setScene(scene);
        popUpStage.show();
    }

    public void openReservationPlaced() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Popups/ReservationPlaced.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        ClosePopUpView view = loader.getController();


        Scene scene = new Scene(root);

        popUpStage.setTitle("Reservation Placed");

        popUpStage.setScene(scene);
        popUpStage.show();
    }

    public void openReservationDeleted() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Popups/ReservationDeleted.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        ClosePopUpView view = loader.getController();


        Scene scene = new Scene(root);

        popUpStage.setTitle("Reservation Deleted");

        popUpStage.setScene(scene);
        popUpStage.show();

    }

    public void openWrongUsernamePassword() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Popups/WrongUsernamePassword.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        ClosePopUpView view = loader.getController();

        Scene scene = new Scene(root);

        popUpStage.setTitle("Error!");

        popUpStage.setScene(scene);
        popUpStage.show();
    }

    public void openLogOutReminder() {
        viewModelProvider.instantiateLogOutViewModel(this);
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Popups/LogOutReminder.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        LogOutReminderView view = loader.getController();
        view.init(viewModelProvider.getLogOutViewModel());


        Scene scene = new Scene(root);


        popUpStage.setTitle("Logging out");

        popUpStage.setScene(scene);
        popUpStage.show();
    }

    public void openCarDeleted() {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Popups/CarDeleted.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        ClosePopUpView view = loader.getController();


        Scene scene = new Scene(root);


        popUpStage.setTitle("Logging out");

        popUpStage.setScene(scene);
        popUpStage.show();
    }
    public void openCarAdded(){
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Popups/CarAdded.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        ClosePopUpView view = loader.getController();


        Scene scene = new Scene(root);


        popUpStage.setTitle("Logging out");

        popUpStage.setScene(scene);
        popUpStage.show();

    }

    public void openReservationAccepted() {

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/MVVM/view/Popups/ReservationAccepted.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {

            e.printStackTrace();
        }
        ClosePopUpView view = loader.getController();


        Scene scene = new Scene(root);


        popUpStage.setTitle("Reservation accepted");

        popUpStage.setScene(scene);
        popUpStage.show();
    }
}
