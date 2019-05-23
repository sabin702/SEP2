package view.Tabs.EmployeeTabPane;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import view.Tabs.EmployeeTabPane.AddCar.AddCarView;
import view.Tabs.EmployeeTabPane.CarsTab.CarsView;
import view.Tabs.EmployeeTabPane.ReservationsTab.ReservationsView;
import view.Tabs.EmployeeTabPane.UsersTab.UsersView;
import javafx.fxml.FXML;
import viewmodel.ViewModelProvider;

public class EmployeeTabPaneView {
    @FXML
    private TabPane employeeTabPane;
    @FXML
    private Tab reservationsTab;
    @FXML
    private Tab carsTab;
    @FXML
    private Tab usersTab;
    @FXML
    private ReservationsView reservationsViewController;
    @FXML
    private CarsView carsViewController;
    @FXML
    private UsersView usersViewController;


    public void init(ViewModelProvider vmp) {
        reservationsViewController.init(vmp.getReservationsViewModel());
        carsViewController.init(vmp.getCarsViewModel());
        usersViewController.init(vmp.getUsersViewModel());



    }
}
