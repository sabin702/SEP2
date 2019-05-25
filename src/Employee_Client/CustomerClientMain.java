package Employee_Client;

import Model.CustomerModel;
import Model.CustomerModelImpl;
import javafx.application.Application;
import server.IServerModel;
import server.ServerModel;
import view.ViewHandler;
import viewmodel.ViewModelProvider;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerClientMain {

    public static void main(String[] args){

        Application.launch(CustomerMain.class);
        //client.addCarToDatabase("M12345", "Mercedes", 30, "gray", 2015, 1);

        //client.getCars();

        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //Date date1 = format.parse("2019-03-11");
        //Date date2 = format.parse("2019-03-21");
        //Date dateOfBirth = format.parse("1971-05-16");

        //client.addCustomer("john", "pass", "John", "Ford", dateOfBirth);

        //client.addReservation("R24680", "A12345", "john", date1, date2, 1,1,"John","Wick", 35, 2000, 1, 0);
    }

}
