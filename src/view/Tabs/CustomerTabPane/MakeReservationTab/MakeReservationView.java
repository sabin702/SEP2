package view.Tabs.CustomerTabPane.MakeReservationTab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import viewmodel.MakeReservationTab.MakeReservationViewModel;

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
    private ComboBox<?> car;

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

    }



}