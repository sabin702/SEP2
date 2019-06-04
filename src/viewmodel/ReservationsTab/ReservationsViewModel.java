package viewmodel.ReservationsTab;


import DataModel.Customer;
import DataModel.Reservation;
import DataModel.ReservationList;
import Model.CustomerModel;
import Model.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.ViewHandler;

import java.beans.PropertyChangeEvent;
import java.io.Serializable;
import java.rmi.RemoteException;

public class ReservationsViewModel {
    private EmployeeModel model;

    private ObservableList<Reservation> reservations;
    private ObservableList<Customer> customers;
    private ViewHandler viewHandler;


    public ReservationsViewModel(ViewHandler viewHandler,EmployeeModel em) throws RemoteException {
        reservations = FXCollections.observableArrayList();
        customers = FXCollections.observableArrayList();


        this.model = em;
        this.viewHandler = viewHandler;


        getReservations();

        model.addListener("ReservationsUpdated", this::updateReservationList);

    }




    public void updateReservationList(PropertyChangeEvent propertyChangeEvent) {
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
            for (int i = 0; i < model.getReservations().size(); i++) {
                Reservation temp = model.getReservations().getReservation(i);
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

    public void approveReservation(String reservationId) throws RemoteException {
        model.approveReservation(reservationId);
    }

    /*public void reservationAdded(PropertyChangeEvent evt){
        System.out.println("here");
        //reservations.add((Reservation) evt.getNewValue());
        try {
            updateReservationList();
        } catch (RemoteException e) {
            e.printStackTrace();
        }*/


    public void reservationRemoved(PropertyChangeEvent evt) {
        reservations.remove((Reservation) evt.getNewValue());
        System.out.println("New size: " + reservations.size());
    }

    public ObservableList<Reservation> getReservationsList() {
        return reservations;
    }

    public int getReservationIndex(String reservationId) throws RemoteException {
        for (int i = 0; i < model.getReservations().size(); i++) {
            if (model.getReservation(reservationId).equals(model.getReservations().getReservation(i)))
                return i;
        }

        return -1;
    }


    public void openReservationAccepted() {
        viewHandler.openReservationAccepted();
    }

    public void openReservationDeleted() {
        viewHandler.openReservationDeleted();
    }
}
