package MVVM.view.Tabs.EmployeeTabPane.UsersTab;

import shared.DataModel.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import MVVM.viewmodel.UsersTab.UsersViewModel;

public class UsersView {
    private UsersViewModel viewModel;
    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TableColumn<String, Customer> nameColumn;

    @FXML
    private TableColumn<String, Customer> surnameColumn;

    @FXML
    private TableColumn<String, Customer> birthColumn;

    @FXML
    private TableColumn<String, Customer> usernameColumn;

    public void init(UsersViewModel usersViewModel){
        this.viewModel = usersViewModel;
        tableView.setItems(viewModel.getCustomerList());

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
    }
}
