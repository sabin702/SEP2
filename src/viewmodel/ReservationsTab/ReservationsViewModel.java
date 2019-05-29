package viewmodel.ReservationsTab;


import DataModel.Reservation;
import Model.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.rmi.RemoteException;

public class ReservationsViewModel {
    private EmployeeModel model;
    private ObservableList<Reservation> reservations;


    public ReservationsViewModel() {
        reservations = FXCollections.observableArrayList();

    }
    public void getReservations() throws RemoteException {
        for (int i = 0; i < model.getReservations().size(); i++) {
            Reservation temp = model.getReservations().getReservation(i);
            reservations.add(temp);
        }
    }
    public ObservableList<Reservation> getReservationsList(){
        return reservations;
    }



}
