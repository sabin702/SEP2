package view.Tabs.CustomerTabPane.ViewReservationsTab;

import DataModel.Reservation;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import viewmodel.ReservationsTab.ReservationsViewModel;
import viewmodel.ViewReservationsTab.ViewReservationsViewModel;

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
        }
    }

    private ObjectProperty< ObservableList<Reservation> > propertyReservations;


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
    }

}

