package Client;

import DataModel.Reservation;
import DataModel.ReservationList;

import java.util.LinkedList;
import java.util.List;

public class AServerSubject implements IServerSubject{
    List<IServerListener> listeners;

    public AServerSubject() { listeners = new LinkedList<>();
    }

    public void addServerListener(IServerListener listener) {
        listeners.add(listener);
        System.out.println("AServerSubject listener added");
    }

    public void fireAddReservation(Reservation reservation) {

        listeners.forEach(l -> l.addReservation(reservation));
        System.out.println("Jestesmy tutaj");
    }

}
