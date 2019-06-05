package MVVM.view.Tabs.EmployeeTabPane;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import MVVM.view.Tabs.EmployeeTabPane.AddCarTab.AddCarView;
import MVVM.view.Tabs.EmployeeTabPane.CarsTab.CarsView;
import MVVM.view.Tabs.EmployeeTabPane.ReservationsTab.ReservationsView;
import MVVM.view.Tabs.EmployeeTabPane.UsersTab.UsersView;
import javafx.fxml.FXML;
import MVVM.viewmodel.VMProvider;

public class EmployeeTabPaneView {

    public void init(VMProvider vmp) {
        reservationsViewController.init(vmp.getReservationsViewModel());
        carsViewController.init(vmp.getCarsViewModel());
        usersViewController.init(vmp.getUsersViewModel());
        addCarViewController.init(vmp.getAddCarViewModel());
    }

    @FXML
    private TabPane employeeTabPane;
    @FXML
    private Tab reservationsTab;
    @FXML
    private Tab carsTab;
    @FXML
    private Tab addCarTab;
    @FXML
    private Tab usersTab;
    @FXML
    private ReservationsView reservationsViewController;
    @FXML
    private CarsView carsViewController;
    @FXML
    private UsersView usersViewController;
    @FXML
    private AddCarView addCarViewController;
}
