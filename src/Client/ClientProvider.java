package Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientProvider {

    ClientImpl clientImpl;
    RMIClient rmiClient;

    public ClientProvider() {
        try {
            rmiClient = new RMIClient();
            clientImpl = new ClientImpl(rmiClient);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public ClientImpl getClientImpl(){
        return clientImpl;
    }
}
