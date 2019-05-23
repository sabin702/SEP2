package DataModel;

import java.util.ArrayList;

public class ReservationList {

    private ArrayList<Reservation> reservations;

    public ReservationList() {
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void addReservation(int index, Reservation reservation){
        reservations.add(index, reservation);
    }

    public void removeReservation(int index){
        reservations.remove(index);
    }

    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
    }

    public int size(){
        return reservations.size();
    }

}
