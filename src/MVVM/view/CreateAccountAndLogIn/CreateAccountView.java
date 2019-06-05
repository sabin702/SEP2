package MVVM.view.CreateAccountAndLogIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import MVVM.viewmodel.AccountAndLogIn.CreateAccountViewModel;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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
    private PasswordField passwordField;

    @FXML
    void createAccount(ActionEvent event) throws IOException {
        if(dateOfBirthField.getValue() == null || nameField.getText().equals("")|| surnameField.getText().equals("")||
        loginField.getText().equals("") || passwordField.getText().equals("")){
            viewModel.openEmptyTextFields();
        }
        else{

        LocalDate localDate = dateOfBirthField.getValue();
        Date birthdate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(birthdate);
        System.out.println(nameField.getText());
        System.out.println(surnameField.getText());
        System.out.println(loginField.getText());
        System.out.println(passwordField.getText());

        viewModel.createAccount(loginField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText(), birthdate);
        viewModel.openCreateAccountAndLogIn();
        }

    }
    @FXML
    void goBack(ActionEvent event) throws IOException {
        viewModel.openCreateAccountAndLogIn();
    }

    public void init(CreateAccountViewModel createAccountViewModel) {
        this.viewModel = createAccountViewModel;
    }
}
