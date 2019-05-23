package view.Tabs.CustomerTabPane.ViewReservationsTab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import viewmodel.ViewReservationsTab.ViewReservationsViewModel;

public class ViewReservationsView {
    @FXML
    private TableColumn<?, ?> dateFromColumn;

    @FXML
    private TableColumn<?, ?> dateToColumn;

    @FXML
    private TableColumn<?, ?> carColumn;

    @FXML
    private TableColumn<?, ?> childSeatColumn;

    @FXML
    private TableColumn<?, ?> naviColumn;

    @FXML
    private TableColumn<?, ?> insuranceColumn;

    @FXML
    private TableColumn<?, ?> statusColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    private ViewReservationsViewModel viewReservationsViewModel;

    @FXML
    void deleteReservation(ActionEvent event) {

    }

}

