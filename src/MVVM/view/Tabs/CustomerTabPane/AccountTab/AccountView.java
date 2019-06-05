package MVVM.view.Tabs.CustomerTabPane.AccountTab;

import shared.DataModel.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import MVVM.viewmodel.AccountTab.AccountViewModel;

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
    private TextField passwordTextField;

    @FXML
    void editUserData(ActionEvent event) throws RemoteException {
        if (editButton.getText().equals("Edit")) {
            nameTextField.setEditable(true);
            surnameTextField.setEditable(true);
            passwordTextField.setEditable(true);
            editButton.setText("Save");
        } else if (editButton.getText().equals("Save")) {
            if (nameTextField.getText().equals("") || surnameTextField.getText().equals("") || passwordTextField.getText().equals("")) {
                viewModel.openEmptyTextFields();
                editButton.setText("Save");
            }
            else {
                nameTextField.setEditable(false);
                surnameTextField.setEditable(false);
                passwordTextField.setEditable(false);
                Customer customer = viewModel.getCustomer(viewModel.getUsername());
                viewModel.editCustomer(customer.getUsername(), nameTextField.getText(), surnameTextField.getText(), passwordTextField.getText());
                editButton.setText("Edit");
            }
        }
    }

    @FXML
    void logOut(ActionEvent event) {
        viewModel.openLogOutReminder();
    }

    public void init(AccountViewModel accountViewModel) {
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
