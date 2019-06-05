package MVVM.view.Tabs.CustomerTabPane.ViewReservationsTab;

import shared.DataModel.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import MVVM.viewmodel.ViewReservationsTab.ViewReservationsViewModel;

import java.rmi.RemoteException;

public class ViewReservationsView {
    private ViewReservationsViewModel viewModel;

    @FXML
    private TableView<Reservation> tableView;
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
    private TableColumn<String, Reservation> insuranceColumn;

    @FXML
    private TableColumn<String, Reservation> statusColumn;

    @FXML
    private TableColumn<String, Reservation> priceColumn;

    private ViewReservationsViewModel viewReservationsViewModel;

    @FXML
    void deleteReservation(ActionEvent event) throws RemoteException {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            viewModel.deleteReservation(tableView.getItems().get(selectedIndex).getReservationId());
            viewModel.openDeleteReservation();
        }
    }

    public void init(ViewReservationsViewModel viewReservationsViewModel) {
        this.viewModel = viewReservationsViewModel;


        tableView.setItems(viewModel.getReservationList());

        dateFromColumn.setCellValueFactory(new PropertyValueFactory<>("dateFrom"));
        dateToColumn.setCellValueFactory(new PropertyValueFactory<>("dateTo"));
        carColumn.setCellValueFactory(new PropertyValueFactory<>("carRegNo"));
        childSeatColumn.setCellValueFactory(new PropertyValueFactory<>("childseat"));
        naviColumn.setCellValueFactory(new PropertyValueFactory<>("navigation"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        insuranceColumn.setCellValueFactory(new PropertyValueFactory<>("insurance"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        for (int i = 0; i < tableView.getItems().size(); i++) {
            System.out.println(statusColumn.getCellObservableValue(i).getValue());
            statusColumn.getCellObservableValue(i).getValue();
            statusColumn.getCellObservableValue(i);
        }

    }

}

