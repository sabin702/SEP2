package MVVM.view.CreateAccountAndLogIn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import MVVM.viewmodel.AccountAndLogIn.CreateAccountAndLogInViewModel;

import java.io.IOException;

public class CreateAccountAndLogInView {

    private CreateAccountAndLogInViewModel viewModel;
    public void init(CreateAccountAndLogInViewModel createAccountAndLogInViewModel) {
        this.viewModel = createAccountAndLogInViewModel;
    }

    @FXML
    void viewCreateAccountFields(ActionEvent event) throws IOException {
        viewModel.openCreateAccount();

    }

    @FXML
    void viewLoginFields(ActionEvent event) throws IOException {
        viewModel.openLogIn();

    }
}
