package MVVM.view.Tabs.CustomerTabPane.MakeReservationTab;

import shared.DataModel.Car;
import shared.DataModel.Customer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import MVVM.viewmodel.MakeReservationTab.MakeReservationViewModel;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

public class MakeReservationView {
    private MakeReservationViewModel viewModel;
    private ObservableList<Car> cars;

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

    @FXML
    void confirmReservation(ActionEvent event) {
        if(dateFrom.getValue() == null || dateTo.getValue() == null || car.getValue() == null){
            viewModel.openEmptyTextFields();
        }
        else {
            LocalDate localDate = dateFrom.getValue();
            Date dateFrom1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            localDate = dateTo.getValue();
            Date dateTo1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            int insurance;

            System.out.println(car.getItems().get(car.getSelectionModel().getSelectedIndex()));

            if (insuranceType.getSelectionModel().getSelectedItem().equals("Basic (25 DKK/day)"))
                insurance = 1;
            else if (insuranceType.getSelectionModel().getSelectedItem().equals("Basic (50 DKK/day)"))
                insurance = 2;
            else if (insuranceType.getSelectionModel().getSelectedItem().equals("Full Coverage (100 DKK/day)"))
                insurance = 3;
            else
                insurance = 0;

            System.out.println("Insurance: " + insurance);

            Random random = new Random();
            String reservationId = "R" + (random.nextInt(88888) + 10000);
            int price = getCar().getPrice() * getNumberOfDays(dateFrom1, dateTo1);
            int navigationOption = 0;
            int childSeatOption = 0;
            if (navigation.isSelected())
                navigationOption = 1;
            if (childSeat.isSelected())
                childSeatOption = 1;


            try {
                Customer customer = viewModel.getCustomer(viewModel.getUsername());
                viewModel.makeReservation(reservationId, getCar().getRegistrationNumber(), customer.getUsername(), dateFrom1, dateTo1, navigationOption, childSeatOption, customer.getFirstName(), customer.getLastName(), customer.getAge(), price, 2, 0);
            } catch (RemoteException e) {
                System.out.println("not working");
                e.printStackTrace();
            }

            clearFields();
            viewModel.openReservationPlaced();
        }
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
                LocalDate to = dateFrom.getValue();

                setDisable(empty || date.compareTo(to)<1);
            }
        });

        LocalDate today = LocalDate.now();
        LocalDate tommorow = today.plus(1, ChronoUnit.DAYS);

        dateFrom.setValue(today);
        dateTo.setValue(tommorow);
        setCarList();
        setInsuranceList();
        updatePrice();
    }

    public void setCarList(){
        car.getItems().removeAll(car.getItems());
        car.setItems(viewModel.getCarsList());
    }

    public void setInsuranceList(){
        insuranceType.getItems().removeAll();
        insuranceType.getItems().addAll("Basic (25 DKK/day)", "Medium (50 DKK/day)", "Full Coverage (100 DKK/day)");
        insuranceType.getSelectionModel().select(" ");
    }

    public Car getCar(){
        cars = viewModel.getCarsList();

        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car 1: " + cars.get(i).getRegistrationNumber());
            System.out.println("Car 2: " + car.getSelectionModel().getSelectedItem().getRegistrationNumber());
            if(cars.get(i).getRegistrationNumber().equals(car.getSelectionModel().getSelectedItem().getRegistrationNumber())){
                return cars.get(i);
            }
            else
                System.out.println("Is null");
        }
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

    public int getCarPrice(){
        car.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            totalPrice.setText(calculateTotalPrice() + " dkk");

            System.out.println("Insurance price: " + newValue);
                }
        );
        return 0;
    }

    public int getInsurance(){
        if(insuranceType.getSelectionModel().getSelectedItem().equals("Basic (25 DKK/day)"))
            return 25;
        else if(insuranceType.getSelectionModel().getSelectedItem().equals("Medium (50 DKK/day)"))
            return 50;
        else if(insuranceType.getSelectionModel().getSelectedItem().equals("Full Coverage (100 DKK/day)"))
            return 100;
        else
            return 0;
    }

    public int getNavigationPrice(){
        if(navigation.isSelected())
            return 50;
        return 0;
    }

    public int getChildSeatPrice(){
        if(childSeat.isSelected())
            return 75;
        return 0;
    }

    @FXML
    void getTotalPrice(ActionEvent evt){
        LocalDate localDate = dateFrom.getValue();
        Date dateFrom1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        localDate = dateTo.getValue();
        Date dateTo1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        int price = getCarPrice() * getNumberOfDays(dateFrom1, dateTo1);
        totalPrice.setText(100 + " dkk");
    }

    public int calculateTotalPrice(){
        int insurancePrice  = 0;
        if(insuranceType.getValue().equals("Basic (25 DKK/day)"))
            insurancePrice = 25;
        else if(insuranceType.getSelectionModel().getSelectedItem().equals("Medium (50 DKK/day)"))
            insurancePrice =  50;
        else if(insuranceType.getSelectionModel().getSelectedItem().equals("Full Coverage (100 DKK/day)"))
            insurancePrice =  100;
        int price = insurancePrice;
        LocalDate localDate = dateFrom.getValue();
        Date dateFrom1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        localDate = dateTo.getValue();
        Date dateTo1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("Days: " + getNumberOfDays(dateFrom1, dateTo1));

        int carPrice = car.getSelectionModel().getSelectedItem().getPrice();
        int navPrice = getNavigationPrice();
        int csPrice = getChildSeatPrice();

        if (dateFrom1.equals(null) || dateTo1.equals(null))
            price = (carPrice + navPrice + csPrice + insurancePrice);
        else if (dateFrom1.equals(null) && dateTo1.equals(null))
            price = (carPrice + navPrice + csPrice + insurancePrice);
        else
            price = (carPrice + navPrice + csPrice + insurancePrice) * getNumberOfDays(dateFrom1, dateTo1);

        return price;
    }

    public void updatePrice(){
        insuranceType.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {

                    totalPrice.setText(calculateTotalPrice() + " dkk");

                    System.out.println("Insurance price: " + newValue);
                }
        );
    }

}