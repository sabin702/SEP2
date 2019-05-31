package viewmodel.MakeReservationTab;

import DataModel.CarList;
import DataModel.Customer;
import DataModel.ReservationList;
import Model.CustomerModel;
import Model.EmployeeModel;
import view.ViewHandler;

import java.rmi.RemoteException;
import java.util.Date;

public class MakeReservationViewModel {
    private ViewHandler viewHandler;
    private CustomerModel cm;
    private String userName;

    public MakeReservationViewModel(ViewHandler viewHandler, CustomerModel cm) {
        this.viewHandler = viewHandler;
        this.cm = cm;
    }
    public void makeReservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) throws RemoteException {
        cm.makeReservation(reservationId, carRegNo, username, dateFrom, dateTo, navigation, childseat, firstName, lastName,age, price,insurance,status);
    }
    public CarList getCars() throws RemoteException {
        return cm.getCars();
    }

    public ReservationList getReservations() throws RemoteException {
        return cm.viewReservations();
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
        return cm.getCustomer(userName);
    }
}