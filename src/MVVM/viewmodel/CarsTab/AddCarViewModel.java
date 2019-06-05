package MVVM.viewmodel.CarsTab;

import MVVM.Model.Employee.EmployeeModel;
import MVVM.view.ViewHandler;

import java.rmi.RemoteException;

public class AddCarViewModel {
    private ViewHandler viewHandler;
    private EmployeeModel model;
    public AddCarViewModel(ViewHandler vh, EmployeeModel model){
        this.model = model;
        this.viewHandler = vh;
    }
    public void addCar(String regNum,String make,int mileage,String color,int productionYear,String category,int price, int availability) throws RemoteException {
        model.addCar(regNum,make,mileage,color,productionYear,category,price,availability);
    }

    public void openEmptyTextFields() {
        viewHandler.openEmptyTextFields();
    }

    public void openCarAdded() {
        viewHandler.openCarAdded();
    }
}
