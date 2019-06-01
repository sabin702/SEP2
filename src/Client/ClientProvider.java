package Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientProvider {

    Client client;
    IRMIClient rmiClient;

    public ClientProvider() {
        try {
            rmiClient = new RMIClient();
            client = new ClientImpl(rmiClient);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public Client getClient() throws RemoteException, NotBoundException {
        if(client == null)
            client = new ClientImpl(getRMIClient());
        return client;
    }

    public IRMIClient getRMIClient() throws RemoteException, NotBoundException {
        if(rmiClient == null)
            rmiClient = new RMIClient();
        return rmiClient;
    }
}
