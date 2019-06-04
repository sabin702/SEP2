package viewmodel.MakeReservationTab;

import DataModel.Car;
import DataModel.CarList;
import DataModel.Customer;
import DataModel.ReservationList;
import Model.CustomerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.ViewHandler;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
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
        cars.removeAll();
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

    public String getString(){
        return "sth";
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
}