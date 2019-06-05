package database.CarsDatabaseConnection;

import shared.DataModel.Car;
import shared.DataModel.CarList;

public interface CarsDAO {

    void addCar(Car car);

    //Here we delete cars from the database by the registration number of the car
    void deleteCar(String registrationNumber);

    void editCar(String registrationNumber, int mileage, int price, int availability);

    Car getCar(String regNo);

    CarList getCars();

    void connectToDatabase();

}
