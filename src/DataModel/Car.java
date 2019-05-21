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

    public Car(String registrationNumber, String make, int mileage, String color, int productionYear, int availability) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.mileage = mileage;
        this.color = color;
        this.productionYear = productionYear;
        this.availability = availability;

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

    public String toString(){

        return "Reg. no.: " + registrationNumber + "|  "
                + "Make: " + make + "|  "
                + "Mileage: " + mileage + "|  "
                + "Color: " + color + "|  "
                + "Prod. year: " + productionYear + "|  "
                + "Status: " + status + "\n";
    }
}
