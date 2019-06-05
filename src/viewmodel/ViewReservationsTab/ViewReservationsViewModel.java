package viewmodel.ViewReservationsTab;


import DataModel.Reservation;
import DataModel.ReservationList;
import Model.Customer.CustomerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.ViewHandler;

import java.beans.PropertyChangeEvent;
import java.io.Serializable;
import java.rmi.RemoteException;

public class ViewReservationsViewModel implements Serializable {

    private  CustomerModel model;
    private  ObservableList<Reservation> reservations;
    private ViewHandler viewHandler;

    public ViewReservationsViewModel(ViewHandler viewHandler,CustomerModel model) throws RemoteException {
        reservations = FXCollections.observableArrayList();
        this.viewHandler = viewHandler;

        this.model = model;

        getReservations();

        model.addListener("CustomerReservationsUpdated", this::updateReservationList);
    }

    private void updateReservationList(PropertyChangeEvent propertyChangeEvent) {
        reservations.clear();
        System.out.println(reservations.size());
        System.out.println("updated");

        ReservationList reservationList = (ReservationList) propertyChangeEvent.getNewValue();

        for (int i = 0; i <reservationList.size(); i++) {
            Reservation temp = reservationList.getReservation(i);
            reservations.add(temp);
        }
    }

    private void getReservations() {
        try {
            for (int i = 0; i < model.getCustomerReservations().size(); i++) {
                Reservation temp = model.getCustomerReservations().getReservation(i);
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

    public void openDeleteReservation() {
        viewHandler.openReservationDeleted();
    }

}

