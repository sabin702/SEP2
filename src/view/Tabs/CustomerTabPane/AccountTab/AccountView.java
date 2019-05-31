package view.Tabs.CustomerTabPane.AccountTab;

import DataModel.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import viewmodel.AccountTab.AccountViewModel;

import java.io.IOException;
import java.rmi.RemoteException;

public class AccountView {

    private AccountViewModel viewModel;

    @FXML
    private Button editButton;
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private CheckBox passwordVisibilityCheckBox;

    @FXML
    void editUserData(ActionEvent event) {
        if (editButton.getText().equals("Edit")) {
            nameTextField.setEditable(true);
            surnameTextField.setEditable(true);
            //passwordTextField.setEditable(true);
            editButton.setText("Save");
        } else if (editButton.getText().equals("Save")) {
            nameTextField.setEditable(false);
            surnameTextField.setEditable(false);
            //passwordTextField.setEditable(false);
            editButton.setText("Edit");
        }

    }


    private AccountViewModel accountViewModel;

    @FXML
    void logOut(ActionEvent event) throws IOException {
        viewModel.openCreateAccountAndLogin();
    }


    @FXML
    void setPasswordVisible(ActionEvent event) {
        /*if(passwordVisibilityCheckBox.isSelected())
            passwordTextField.setVisible(false);
        else
            passwordTextField.setVisible(true);*/
    }

    public void init(AccountViewModel accountViewModel){
        this.viewModel = accountViewModel;
        Customer customer = null;
        try {
            customer = viewModel.getCustomer(viewModel.getUsername());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        nameTextField.setText(customer.getFirstName());
        surnameTextField.setText(customer.getLastName());
        passwordTextField.setText(customer.getPassword());
        nameTextField.setEditable(false);
        surnameTextField.setEditable(false);
        passwordTextField.setEditable(false);
    }


}
