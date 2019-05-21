package view.Tabs.EmployeeTabPane.ReservationsTab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ReservationsView {

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> customerColumn;

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
    private TableColumn<?, ?> statusColumn;

    @FXML
    private TableColumn<?, ?> insuranceColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    void approveReservation(ActionEvent event) {

    }

    @FXML
    void deleteReservation(ActionEvent event) {

    }

}
