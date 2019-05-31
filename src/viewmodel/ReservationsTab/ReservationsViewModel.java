package viewmodel.ReservationsTab;


import DataModel.Reservation;
import Model.CustomerModel;
import Model.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;

public class ReservationsViewModel {
    private EmployeeModel em;
    private CustomerModel cm;
    private ObservableList<Reservation> reservations;


    public ReservationsViewModel(CustomerModel cm, EmployeeModel em) {
        reservations = FXCollections.observableArrayList();

        this.cm = cm;
        this.em = em;

        getReservations();

        cm.addListener("ReservationAdded", this::reservationAdded);
        cm.addListener("ReservationDeleted", this::reservationRemoved);
        em.addListener("ReservationDeleted", this::reservationRemoved);
    }

    private void getReservations() {
        try {
            for (int i = 0; i < cm.viewReservations().size(); i++) {
                Reservation temp = cm.viewReservations().getReservation(i);
                reservations.add(temp);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void deleteReservation(String reservationId) throws RemoteException {
        System.out.println("Current size: " + reservations.size());
        reservations.remove(getReservationIndex(reservationId));
        System.out.println("ddhe: " + reservations.size());
        cm.deleteReservation(reservationId);
        System.out.println("Item deleted");
    }

    public void reservationAdded(PropertyChangeEvent evt){
        System.out.println("here");
        reservations.add((Reservation) evt.getNewValue());
    }

    public void reservationRemoved(PropertyChangeEvent evt){
        reservations.remove((Reservation) evt.getNewValue());
        System.out.println("New size: " + reservations.size());
    }

    public ObservableList<Reservation> getReservationsList(){
        return FXCollections.unmodifiableObservableList(reservations);
    }

    public int getReservationIndex(String reservationId) throws RemoteException {
        for (int i = 0; i < cm.viewReservations().size(); i++) {
            if(cm.getReservation(reservationId).equals(cm.viewReservations().getReservation(i)))
                return i;
        }

        return -1;
    }



}
