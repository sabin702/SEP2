package Client;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientProvider implements Serializable {

    private Client client;
   private IRMIClient rmiClient;

    public ClientProvider() throws RemoteException, NotBoundException {

            rmiClient = new RMIClient();
            client = new ClientImpl(rmiClient);

    }

    public Client getClient() throws RemoteException, NotBoundException {

        return client;
    }

    public IRMIClient getRMIClient() throws RemoteException, NotBoundException {

        return rmiClient;
    }
}
