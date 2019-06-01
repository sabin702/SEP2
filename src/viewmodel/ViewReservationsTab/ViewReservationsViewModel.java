package viewmodel.ViewReservationsTab;


import Client.IServerListener;
import DataModel.Reservation;
import DataModel.ReservationList;
import Model.CustomerModel;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ViewReservationsViewModel {

    private CustomerModel model;
    private ObservableList<Reservation> reservations;

    public ViewReservationsViewModel(CustomerModel model) {
        reservations = FXCollections.observableArrayList();

        this.model = model;

        getReservations();

        model.addListener("ReservationAdded", this::reservationAdded);
        model.addListener("ReservationDeleted", this::reservationRemoved);


    }

    private void getReservations() {
        try {
            for (int i = 0; i < model.viewReservations().size(); i++) {
                Reservation temp = model.viewReservations().getReservation(i);
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
        model.deleteReservation(reservationId);
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

    public ObservableList<Reservation> getReservationList()
    {
        return reservations;
    }



    public int getReservationIndex(String reservationId) throws RemoteException {
        for (int i = 0; i < model.viewReservations().size(); i++) {
            if(model.getReservation(reservationId).equals(model.viewReservations().getReservation(i)))
                return i;
        }

        return -1;
    }

}

