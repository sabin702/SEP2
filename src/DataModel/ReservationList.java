package DataModel;

import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable {

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

    public int size(){
        return reservations.size();
    }

    public Reservation getReservation(int index){
        return reservations.get(index);
    }

}
