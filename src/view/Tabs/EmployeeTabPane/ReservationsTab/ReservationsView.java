package view.Tabs.EmployeeTabPane.ReservationsTab;

import DataModel.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import viewmodel.ReservationsTab.ReservationsViewModel;

import java.rmi.RemoteException;

public class ReservationsView {
    private ReservationsViewModel viewModel;

    @FXML
    private TableView<Reservation> tableView;
    @FXML
    private TableColumn<String, Reservation> idColumn;

    @FXML
    private TableColumn<String, Reservation> customerColumn;

    @FXML
    private TableColumn<String, Reservation> dateFromColumn;

    @FXML
    private TableColumn<String, Reservation> dateToColumn;

    @FXML
    private TableColumn<String, Reservation> carColumn;

    @FXML
    private TableColumn<String, Reservation> childSeatColumn;

    @FXML
    private TableColumn<String, Reservation> naviColumn;

    @FXML
    private TableColumn<String, Reservation> statusColumn;

    @FXML
    private TableColumn<String, Reservation> insuranceColumn;

    @FXML
    private TableColumn<String, Reservation> priceColumn;

    @FXML
    void approveReservation(ActionEvent event) throws RemoteException {
        viewModel.approveReservation(tableView.getSelectionModel().getSelectedItem().getReservationId());
    }

    @FXML
    void deleteReservation(ActionEvent event) throws RemoteException {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            viewModel.deleteReservation(tableView.getItems().get(selectedIndex).getReservationId());
        }
    }

    public void init(ReservationsViewModel reservationsViewModel) {
        this.viewModel = reservationsViewModel;



        //System.out.println(viewModel.getReservationsList().size());

        tableView.setItems(viewModel.getReservationsList());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        dateFromColumn.setCellValueFactory(new PropertyValueFactory<>("dateFrom"));
        dateToColumn.setCellValueFactory(new PropertyValueFactory<>("dateTo"));
        carColumn.setCellValueFactory(new PropertyValueFactory<>("carRegNo"));
        childSeatColumn.setCellValueFactory(new PropertyValueFactory<>("childseat"));
        naviColumn.setCellValueFactory(new PropertyValueFactory<>("navigation"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        insuranceColumn.setCellValueFactory(new PropertyValueFactory<>("insurance"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

}
