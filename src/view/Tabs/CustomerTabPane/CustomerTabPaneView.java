package view.Tabs.CustomerTabPane;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import view.Tabs.CustomerTabPane.AccountTab.AccountView;
import view.Tabs.CustomerTabPane.MakeReservationTab.MakeReservationView;
import view.Tabs.CustomerTabPane.ViewReservationsTab.ViewReservationsView;

public class CustomerTabPaneView {
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
