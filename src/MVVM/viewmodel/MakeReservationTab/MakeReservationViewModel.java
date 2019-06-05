package MVVM.viewmodel.MakeReservationTab;

import shared.DataModel.Car;
import shared.DataModel.CarList;
import shared.DataModel.Customer;
import shared.DataModel.ReservationList;
import MVVM.Model.Customer.CustomerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import MVVM.view.ViewHandler;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Date;

public class MakeReservationViewModel {
    private ViewHandler viewHandler;
    private CustomerModel model;
    private String userName;
    private ObservableList<Car> cars;

    public MakeReservationViewModel(ViewHandler viewHandler, CustomerModel cm) throws RemoteException {
        cars = FXCollections.observableArrayList();
        this.viewHandler = viewHandler;
        this.model = cm;
        model.addListener("CarsUpdated",this::updateCarsList);
        getCars();
    }

    private void updateCarsList(PropertyChangeEvent propertyChangeEvent) {
        cars.clear();
        System.out.println(cars.size());
        System.out.println("updated");

        CarList carList = (CarList) propertyChangeEvent.getNewValue();

        for (int i = 0; i <carList.size(); i++) {
            Car temp = carList.getCar(i);
            cars.add(temp);
        }
    }

    public void makeReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException {
        model.makeReservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName,age, price,insurance,status);
    }
    public void getCars() {
        try {
            for (int i = 0; i < model.getCars().size(); i++) {
                Car temp = model.getCars().getCar(i);
                cars.add(temp);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public ObservableList<Car> getCarsList() {
        return cars;
    }

    public ReservationList getReservations() throws RemoteException {
        return model.viewReservations();
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUsername(){
        return userName;
    }

    public Customer getCustomer(String userName) throws RemoteException {
        return model.getCustomer(userName);
    }

    public int getNumberOfDays(Date date1, Date date2){
        return model.getNumberOfDays(date1, date2);
    }

    public int calculateTotalPrice(String insuranceType, LocalDate localDate1, LocalDate localDate2, int carPrice, int navPrice, int csPrice){
        return model.calculateTotalPrice(insuranceType, localDate1, localDate2, carPrice, navPrice, csPrice);
    }

    public void openEmptyTextFields() {
        viewHandler.openEmptyTextFields();
    }

    public void openReservationPlaced() {
        viewHandler.openReservationPlaced();
    }
}