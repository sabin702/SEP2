package MVVM.view.Tabs.CustomerTabPane;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import MVVM.view.Tabs.CustomerTabPane.AccountTab.AccountView;
import MVVM.view.Tabs.CustomerTabPane.MakeReservationTab.MakeReservationView;
import MVVM.view.Tabs.CustomerTabPane.ViewReservationsTab.ViewReservationsView;


import MVVM.viewmodel.ViewModelProvider;

public class CustomerTabPaneView {

    public void init(ViewModelProvider vmp) {
        accountViewController.init(vmp.getAccountViewModel());
        makeReservationViewController.init(vmp.getMakeReservationViewModel());
        viewReservationsViewController.init(vmp.getViewReservationsViewModel());
    }

    @FXML
    private TabPane customerTabPane;
    @FXML
    private Tab makeReservationTab;
    @FXML
    private Tab viewReservationsTab;
    @FXML
    private Tab accountTab;
    @FXML
    private AccountView accountViewController;
    @FXML
    private MakeReservationView makeReservationViewController;
    @FXML
    private ViewReservationsView viewReservationsViewController;

}
