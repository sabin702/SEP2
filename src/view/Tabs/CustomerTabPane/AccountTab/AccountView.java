package view.Tabs.CustomerTabPane.AccountTab;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import viewmodel.AccountTab.AccountViewModel;

import java.awt.*;

public class AccountView {
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private CheckBox passwordVisibilityCheckBox;

    @FXML
    void editUserData(ActionEvent event) {

    }
    private AccountViewModel accountViewModel;

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    void saveUserData(ActionEvent event) {

    }

    @FXML
    void setPasswordVisible(ActionEvent event) {

    }

}