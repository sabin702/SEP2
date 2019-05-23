package view.CreateAccountAndLogIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewmodel.AccountAndLogIn.CreateAccountViewModel;
import viewmodel.ViewModelProvider;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        LocalDate localDate = dateOfBirthField.getValue();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = format.parse(localDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        viewModel.createAccount(nameField.getText(), surnameField.getText(), birthDate, loginField.getText(), passwordField.getText());
        viewModel.openCreateAccountAndLogIn();
    }

    public void init(CreateAccountViewModel createAccountViewModel) {
        this.viewModel = createAccountViewModel;
    }

}
