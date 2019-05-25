package view.CreateAccountAndLogIn;

import DataModel.Customer;
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
        /*
        LocalDate localDate = dateOfBirthField.getValue();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-dd");
        Date birthDate = new Date();
        try {
            birthDate = format.parse(localDate.toString());
            System.out.println(birthDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

         */
        LocalDate localDate = dateOfBirthField.getValue();
        Date birthdate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(birthdate);
        System.out.println(nameField.getText());
        System.out.println(surnameField.getText());
        System.out.println(loginField.getText());
        System.out.println(passwordField.getText());

        Customer customer = new Customer(loginField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText(), birthdate);

        viewModel.createAccount(customer);
        viewModel.openCreateAccountAndLogIn();
    }

    public void init(CreateAccountViewModel createAccountViewModel) {
        this.viewModel = createAccountViewModel;
    }

}
