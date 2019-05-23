package view.CreateAccountAndLogIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewmodel.AccountAndLogIn.CreateAccountViewModel;
import viewmodel.ViewModelProvider;

import java.io.IOException;

public class CreateAccountView {

    private CreateAccountViewModel viewModel;
    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private DatePicker dateOfBirthField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        viewModel.openCreateAccountAndLogIn();

    }

    public void init(CreateAccountViewModel createAccountViewModel) {
        this.viewModel = createAccountViewModel;

    }

}
