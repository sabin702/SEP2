package view.Tabs.EmployeeTabPane.CarsTab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import viewmodel.CarsTab.AddCarViewModel;
import viewmodel.CarsTab.CarsViewModel;

import java.io.IOException;

public class CarsView {

    private CarsViewModel viewModel;
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
    void addCarWindow(ActionEvent event) throws IOException {
        viewModel.openAddCar();


    }

    @FXML
    void deleteCar(ActionEvent event) {

    }

    @FXML
    void editCar(ActionEvent event) {

    }
    public void init(CarsViewModel carsViewModel){
        this.viewModel = carsViewModel;
    }


}
