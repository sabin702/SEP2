package view.CreateAccountAndLogIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.Tabs.CustomerTabPane.CustomerTabPaneView;
import viewmodel.AccountAndLogIn.LogInViewModel;

import java.io.IOException;
import java.io.Serializable;

public class LogInView implements Serializable {

    private LogInViewModel viewModel;
    public void init(LogInViewModel logInViewModel){
        this.viewModel = logInViewModel;
    }


    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void logIn(ActionEvent event) throws IOException {
        if(viewModel.logIn(usernameField.getText(), passwordField.getText()))
            viewModel.openCustomerTabPane();
        else
            System.out.println("No match");
    }


}

