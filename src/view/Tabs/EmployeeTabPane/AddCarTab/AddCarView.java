package view.Tabs.EmployeeTabPane.AddCarTab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import viewmodel.CarsTab.AddCarViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCarView implements Initializable {
    private AddCarViewModel viewModel;

    @FXML
    private TextField registrationNumber;

    @FXML
    private TextField carMake;

    @FXML
    private TextField carMileage;

    @FXML
    private TextField carColor;

    @FXML
    private TextField carProduction;

    @FXML
    private ComboBox<String> carCategory;

    @FXML
    private TextField carPrice;

    @FXML
    void addCar(ActionEvent event) {
        int mileage = Integer.parseInt(carMileage.getText());
        int productionYear = Integer.parseInt(carProduction.getText());
        int price = Integer.parseInt(carPrice.getText());
        int availability = 0;
        viewModel.addCar(registrationNumber.getText(),carMake.getText(),mileage,carColor.getText(),productionYear,carCategory.getAccessibleText(),price, availability);

        }


    public void init(AddCarViewModel addCarViewModel){
        this.viewModel = addCarViewModel;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carCategory = new ComboBox<String>();
        carCategory.getItems().removeAll();
        carCategory.getItems().addAll("SUV", "Small car","Sedan","Truck","Cabrio","Hatchback");
    }
}
