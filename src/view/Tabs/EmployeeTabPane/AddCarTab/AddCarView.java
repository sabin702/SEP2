package view.Tabs.EmployeeTabPane.AddCarTab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import viewmodel.CarsTab.AddCarViewModel;

import java.net.URL;
import java.rmi.RemoteException;
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
        if(carMileage.getText().equals("") || carPrice.getText().equals("") || carProduction.getText().equals("") || carColor.getText().equals("") || carMake.getText().equals("") || carCategory.getValue() == null){
            viewModel.openEmptyTextFields();
        }
        else {
            int mileage = Integer.parseInt(carMileage.getText());
            int productionYear = Integer.parseInt(carProduction.getText());
            int price = Integer.parseInt(carPrice.getText());
            int availability = 0;
            try {
                viewModel.addCar(registrationNumber.getText(), carMake.getText(), mileage, carColor.getText(), productionYear, carCategory.getValue(), price, availability);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            clearFields();
            viewModel.openCarAdded();
        }

    }

    public void init(AddCarViewModel addCarViewModel){
        this.viewModel = addCarViewModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carCategory.getItems().removeAll();
        carCategory.getItems().addAll("SUV", "Small car","Sedan","Truck","Cabrio","Hatchback");
        carCategory.getSelectionModel().select("Sedan");
    }

    public void clearFields(){
        registrationNumber.clear();
        carMake.clear();
        carMileage.clear();
        carColor.clear();
        carProduction.clear();
        carCategory.getSelectionModel().select(1);
        carPrice.clear();
    }
}
