package viewmodel.CarsTab;

import DataModel.Car;
import Model.EmployeeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import view.ViewHandler;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;

public class CarsViewModel {

    private EmployeeModel model;
    private ObservableList<Car> cars;

    public CarsViewModel (EmployeeModel model){
        cars = FXCollections.observableArrayList();

        this.model = model;

        getCars();

        model.addListener("CarAdded", this::carAdded);
        model.addListener("CarDeleted", this::carDeleted);
        model.addListener("CarEdited", this::carEdited);
    }

    private void getCars() {
        try {
            for (int i = 0; i < model.getCars().size(); i++) {
                Car temp = model.getCars().getCar(i);
                cars.add(temp);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(String registrationNumber) throws RemoteException {
        cars.remove(getCarIndex(registrationNumber));
        model.deleteCar(registrationNumber);
        System.out.println("Item deleted");
    }

    public void editCar(String registrationNumber, int mileage, int price, int availability) throws RemoteException {
        cars.get(getCarIndex(registrationNumber)).setMileage(mileage);
        cars.get(getCarIndex(registrationNumber)).setPrice(price);
        cars.get(getCarIndex(registrationNumber)).setAvailability(availability);
        model.editCar(registrationNumber, mileage, price, availability);
        System.out.println("Item edited");
    }

    public void carAdded(PropertyChangeEvent evt){
        cars.add((Car) evt.getNewValue());
    }

    public void carDeleted(PropertyChangeEvent evt){
        cars.remove((Car) evt.getNewValue());
    }

    public void carEdited(PropertyChangeEvent evt){

    }


    public ObservableList<Car> getCarList() {
        return FXCollections.unmodifiableObservableList(cars);
    }

    public int getCarIndex(String registrationNumber) throws RemoteException {
        System.out.println("The value is: " + model.getCar(registrationNumber));
        for (int i = 0; i < model.getCars().size(); i++) {
            System.out.println(model.getCars().getCar(i));
            if(model.getCar(registrationNumber).getRegistrationNumber().equals(model.getCars().getCar(i).getRegistrationNumber()))
                return i;
        }

        return -1;
    }

}
