package Client;

import DataModel.ReservationList;

import java.util.LinkedList;
import java.util.List;

public class AServerSubject implements IServerSubject{
    List<IServerListener> listeners;

    public AServerSubject() { listeners = new LinkedList<>();
    }

    public void addServerListener(IServerListener listener) {
        listeners.add(listener);
    }

    protected void fireUpdateReservationList(ReservationList reservationList) {

        listeners.forEach(l -> l.updateReservations(reservationList));
    }

}
