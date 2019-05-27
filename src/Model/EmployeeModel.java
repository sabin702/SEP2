package Model;

import DataModel.Car;
import DataModel.CustomerList;
import Employee_Client.EmployeeClient;

public interface EmployeeModel {

    void setClient(EmployeeClient client);

    void approveReservatiokn(String reservationID);

    void deleteReservation(String reservationID);

    void addCar(Car car);

    void deletCar(String carID);

    void editCar();

    CustomerList viewUsers();

}
