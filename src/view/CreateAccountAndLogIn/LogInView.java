package view.CreateAccountAndLogIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.Tabs.CustomerTabPane.CustomerTabPaneView;
import viewmodel.AccountAndLogIn.LogInViewModel;

import java.io.IOException;

public class LogInView {

    private LogInViewModel viewModel;
    public void init(LogInViewModel logInViewModel){
        this.viewModel = logInViewModel;
    }


    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    void logIn(ActionEvent event) throws IOException {
        viewModel.openCustomerTabPane();

    }


}

