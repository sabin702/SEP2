package Model;

import DataModel.Car;
import DataModel.CustomerList;

public interface EmployeeModel {

    void approveReservatiokn(String reservationID);

    void deleteReservation(String reservationID);

    void addCar(Car car);

    void deletCar(String carID);

    void editCar();

    CustomerList viewUsers();

}
