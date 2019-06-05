package MVVM.view.Tabs.EmployeeTabPane.CarsTab;

import shared.DataModel.Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import MVVM.viewmodel.CarsTab.CarsViewModel;

import java.rmi.RemoteException;

public class CarsView {

    private CarsViewModel viewModel;
    @FXML
    private Button editButton;
    @FXML
    private TableView<Car> tableView;
    @FXML
    private TableColumn<String, Car> registrationColumn;

    @FXML
    private TableColumn<String, Car> makeColumn;

    @FXML
    private TableColumn<String, Car> mileageColumn;

    @FXML
    private TableColumn<String, Car> colorColumn;

    @FXML
    private TableColumn<String, Car> yearColumn;

    @FXML
    private TableColumn<String, Car> availabilityColumn;
    @FXML
    private TableColumn<String, Car> priceColumn;

    @FXML
    void deleteCar(ActionEvent event) throws RemoteException {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            System.out.println(tableView.getItems().get(selectedIndex).getRegistrationNumber());
            viewModel.deleteCar(tableView.getItems().get(selectedIndex).getRegistrationNumber());
            viewModel.openCarDeleted();
        }
    }

    @FXML
    void editCar(ActionEvent event) throws RemoteException {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (editButton.getText().equals("Edit")) {
            if (selectedIndex >= 0) {
                //mileageColumn.getColumns().get(tableView.getSelectionModel().getSelectedIndex()).setEditable(true);
                //System.out.println(tableView.getItems().get(selectedIndex).getRegistrationNumber());
            }
            editButton.setText("Save");
        }else if(editButton.getText().equals("Save")) {
            if (selectedIndex >= 0) {
                Car car = tableView.getItems().get(selectedIndex);
                viewModel.editCar(car.getRegistrationNumber(), car.getMileage(), car.getPrice(), car.getAvailability());
            }
            editButton.setText("Edit");
        }
        }

    public void init(CarsViewModel carsViewModel) {
        this.viewModel = carsViewModel;

        tableView.setItems(viewModel.getCarList());
        registrationColumn.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        mileageColumn.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("productionYear"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
