package DataModel;

import java.io.Serializable;
import java.util.ArrayList;

public class CarList implements Serializable {

    private ArrayList<Car> cars;

    public CarList() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCar(int index, Car car){
        cars.add(index, car);
    }

    public void removeCar(Car car){
        cars.remove(car);
    }

    public void removeCar(int index){
        cars.remove(index);
    }

    public int size(){
        return cars.size();
    }

    public Car getCar(int index){
        return cars.get(index);
    }
}
