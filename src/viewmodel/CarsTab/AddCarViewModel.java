package viewmodel.CarsTab;

import Model.EmployeeModel;
import view.ViewHandler;

import java.rmi.RemoteException;

public class AddCarViewModel {
    private ViewHandler viewHandler;
    private EmployeeModel model;
    public AddCarViewModel(){
        this.viewHandler = viewHandler;
    }
    public void addCar(String registrationNumber,String make,int mileage,String color,int productionYear,String category,int price, int availability) throws RemoteException {
        model.addCar(registrationNumber,make,mileage,color,productionYear,category,price,availability);
    }
}
