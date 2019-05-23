package view.Tabs.CustomerTabPane.AccountTab;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import viewmodel.AccountTab.AccountViewModel;

import java.io.IOException;

public class AccountView {

    private AccountViewModel viewModel;


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
    void logOut(ActionEvent event) throws IOException {
        viewModel.openCreateAccountAndLogin();
    }

    @FXML
    void saveUserData(ActionEvent event) {

    }

    @FXML
    void setPasswordVisible(ActionEvent event) {

    }

    public void init(AccountViewModel accountViewModel){
        this.viewModel = accountViewModel;
    }


}
