package MVVM.view.CreateAccountAndLogIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import MVVM.viewmodel.AccountAndLogIn.LogInViewModel;

import java.io.IOException;
import java.io.Serializable;

public class LogInView implements Serializable {

    private LogInViewModel viewModel;

    public void init(LogInViewModel logInViewModel) {
        this.viewModel = logInViewModel;
    }

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void logIn(ActionEvent event) throws IOException {
        if (usernameField.getText().equals("") || passwordField.getText().equals("")) {
            viewModel.openEmptyTextFields();
        } else {
            if (viewModel.logIn(usernameField.getText(), passwordField.getText())){
                viewModel.openCustomerTabPane();
            viewModel.openLogInWelcome();}
            else{
                viewModel.openWrongUsernamePassword();
            }
            }
        }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        viewModel.openCreateAccountAndLogIn();
    }

}

