package view.Popups;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import viewmodel.AccountTab.LogOutViewModel;

import java.io.IOException;

public class LogOutReminderView {
    private LogOutViewModel viewModel;
    @FXML
    Button closeButton;
    @FXML
    Button logOutButton;
    @FXML
    void closePopUp(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();

    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        // get a handle to the stage
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        // do what you have to do
        stage.close();
        if(viewModel == null){
            System.out.println("View model is Null");
        }
        viewModel.openCreateAccountAndLogIn();

    }

    public void init(LogOutViewModel logOutViewModel){
        this.viewModel = logOutViewModel;
    }

}
