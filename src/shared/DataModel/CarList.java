package shared.DataModel;

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

    public int size(){
        return cars.size();
    }

    public Car getCar(int index){
        return cars.get(index);
    }
}