package DataModel;

import java.io.Serializable;

public class Car implements Serializable {

    private String registrationNumber;
    private String make;
    private int mileage;
    private String color;
    private int productionYear;
    private int availability;
    private String status;
    private String category;
    private int price;

    public Car(String registrationNumber, String make, int mileage, String color, int productionYear, String category, int price, int availability) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.mileage = mileage;
        this.color = color;
        this.productionYear = productionYear;
        this.category = category;
        this.price = price;

        status = "";

        switch (availability){
            case 0:
                status = "unavailable";
                break;
            case 1:
                status = "available";
                break;
            default:
                status = "No status";
        }

    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getStatus() {
        return status;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String toString(){

        return make + ", " + category;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Car))
            return false;
        Car other = (Car) obj;
        return registrationNumber == (other.getRegistrationNumber());
    }
}
