package view.Tabs.EmployeeTabPane.CarsTab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import viewmodel.CarsTab.AddCarViewModel;
import viewmodel.CarsTab.CarsViewModel;

import java.io.IOException;

public class CarsView {

    private CarsViewModel viewModel;
    @FXML
    private Button editButton;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> registrationColumn;

    @FXML
    private TableColumn<?, ?> makeColumn;

    @FXML
    private TableColumn<?, ?> mileageColumn;

    @FXML
    private TableColumn<?, ?> colorColumn;

    @FXML
    private TableColumn<?, ?> yearColumn;

    @FXML
    private TableColumn<?, ?> availabilityColumn;

    @FXML
    void deleteCar(ActionEvent event) {

    }

    @FXML
    void editCar(ActionEvent event) {
        if (editButton.getText().equals("Edit")) {
            editButton.setText("Save");
        }else if(editButton.getText().equals("Save"))
            editButton.setText("Edit");
        }




    public void init(CarsViewModel carsViewModel) {
        this.viewModel = carsViewModel;
    }


}
