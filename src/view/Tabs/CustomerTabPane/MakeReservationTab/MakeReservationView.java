package view.Tabs.CustomerTabPane.MakeReservationTab;

import DataModel.Car;
import DataModel.CarList;
import DataModel.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import viewmodel.MakeReservationTab.MakeReservationViewModel;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class MakeReservationView {
    private MakeReservationViewModel viewModel;

    @FXML
    private DatePicker dateFrom;

    @FXML
    private DatePicker dateTo;

    @FXML
    private ComboBox<Car> car;

    @FXML
    private CheckBox navigation;

    @FXML
    private CheckBox childSeat;

    @FXML
    private ComboBox<String> insuranceType;

    @FXML
    private TextField totalPrice;

    private MakeReservationViewModel makeReservationViewModel;
    private ObservableList<Car> cars;

    @FXML
    void confirmReservation(ActionEvent event) {
        LocalDate localDate = dateFrom.getValue();
        Date dateFrom1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        localDate = dateTo.getValue();
        Date dateTo1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        int insurance;
        switch((String) insuranceType.getValue()){
            case "type1":
                insurance = 1;
            case "type2":
                insurance = 2;
            case "type3":
                insurance = 3;
                default:
                    insurance = 0;
        }
        if(insuranceType.getValue().equals("type1"))
            insurance = 1;
        else if(insuranceType.getValue().equals("type2"))
            insurance = 2;
        else if(insuranceType.getValue().equals("type3"))
            insurance = 3;
        Random random = new Random();
        String reservationId = "R" + (random.nextInt(88888)+10000);
        int price = getCar().getPrice() * getNumberOfDays(dateFrom1, dateTo1);
        int navigationOption = 0;
        int childSeatOption = 0;
        if(navigation.isSelected())
            navigationOption = 1;
        if(childSeat.isSelected())
            childSeatOption = 1;

        try {
            Customer customer = viewModel.getCustomer(viewModel.getUsername());
            viewModel.makeReservation(reservationId, getCar().getRegistrationNumber(), customer.getUsername(), dateFrom1, dateTo1, navigationOption, childSeatOption, customer.getFirstName(), customer.getLastName(), customer.getAge(), price, insurance, 0);
        } catch (RemoteException e) {
            System.out.println("not working");
            e.printStackTrace();
        }
        clearFields();
    }

    public void init(MakeReservationViewModel makeReservationViewModel){
        this.viewModel = makeReservationViewModel;
        dateFrom.setDayCellFactory(picker -> new DateCell(){
            public void updateItem(LocalDate date, boolean empty){
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0);
            }
        });

        dateTo.setDayCellFactory(picker -> new DateCell(){
            public void updateItem(LocalDate date, boolean empty){
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 1);
            }
        });
        setCarList();
        setInsuranceList();
    }

    public void setCarList(){

        car.setItems(viewModel.getCarsList());
        /*car.getItems().removeAll(car.getItems());
        *//*cars = new ObservableList<Car>() {
        };
        try {
            cars = viewModel.getCars();
        } catch (RemoteException e) {
            System.out.println("wrong");
            e.printStackTrace();
        }

        for (int i = 0; i < cars.size(); i++) {
            car.getItems().add(cars.getCar(i));
        }

        car.getSelectionModel().select(1);*/
    }

    public void setInsuranceList(){
        insuranceType.getItems().removeAll();
        insuranceType.getItems().addAll("Basic", "Medium", "Full Coverage");
        insuranceType.getSelectionModel().select(" ");
    }

    public Car getCar(){
       /* cars = new ObservableList<Car>();
        try {
            cars = viewModel.getCarsList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < cars.size(); i++) {
            if(cars.getCar(i).getRegistrationNumber().equals(car.getItems().get(i).getRegistrationNumber()))
                return cars.getCar(i);
            else
                System.out.println("Is null");
        }*/

        return null;

    }

    public int getNumberOfDays(Date date1, Date date2){
        long difference = Math.abs(date2.getTime() - date1.getTime());
        int days = (int) (difference / (1000 * 60 * 60 * 24));
        return days;
    }

    public void clearFields(){
        dateFrom.getEditor().clear();
        dateTo.getEditor().clear();
        car.getSelectionModel().select(1);
        navigation.setSelected(false);
        childSeat.setSelected(false);
        insuranceType.getSelectionModel().select(1);

    }

}