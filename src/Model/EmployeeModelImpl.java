package Model;

import DataModel.Car;
import DataModel.CustomerList;
import Employee_Client.EmployeeClient;

public class EmployeeModelImpl implements EmployeeModel{

    private EmployeeClient client;

    @Override
    public void setClient(EmployeeClient client) {
        this.client = client;
    }

    @Override
    public void approveReservatiokn(String reservationID) {

    }

    @Override
    public void deleteReservation(String reservationID) {

    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void deletCar(String carID) {

    }

    @Override
    public void editCar() {

    }

    @Override
    public CustomerList viewUsers() {
        return null;
    }
}
