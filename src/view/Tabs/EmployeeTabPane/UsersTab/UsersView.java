package view.Tabs.EmployeeTabPane.UsersTab;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import viewmodel.UsersTab.UsersViewModel;

public class UsersView {
    private UsersViewModel viewModel;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> surnameColumn;

    @FXML
    private TableColumn<?, ?> birthColumn;

    @FXML
    private TableColumn<?, ?> usernameColumn;

    public void init(UsersViewModel usersViewModel){
        this.viewModel = usersViewModel;

    }

}
