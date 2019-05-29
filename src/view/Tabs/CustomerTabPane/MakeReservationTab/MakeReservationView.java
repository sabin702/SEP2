package view.Tabs.CustomerTabPane.MakeReservationTab;

import DataModel.Car;
import DataModel.CarList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import viewmodel.MakeReservationTab.MakeReservationViewModel;

import java.util.ArrayList;

public class MakeReservationView {
    private MakeReservationViewModel viewModel;
    public void init(MakeReservationViewModel makeReservationViewModel){
        this.viewModel = makeReservationViewModel;

    }
    @FXML
    private DatePicker dateFrom;

    @FXML
    private DatePicker dateTo;

    @FXML
    private ComboBox<String> car;

    @FXML
    private CheckBox navigation;

    @FXML
    private CheckBox childSeat;

    @FXML
    private ComboBox<?> insuranceType;

    @FXML
    private TextField totalPrice;

    private MakeReservationViewModel makeReservationViewModel;

    @FXML
    void confirmReservation(ActionEvent event) {
        //viewModel.makeReservation("R12345", car.getRegNo(), "john", dateFrom, dateTo, 1, 1, customer.getFirstName(), customer.getLastName(), customer.getAge(), 1);
    }

    public void setData(){
        car = new ComboBox<String>();
        Car car1 = new Car("abcdef", "bjh", 91, "blre", 2018, "nema", 1234, 0);
        car.getItems().add(car1.toString());
    }



}