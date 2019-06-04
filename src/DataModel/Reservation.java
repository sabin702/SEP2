package DataModel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Reservation implements Serializable {

    private String reservationId;
    private String carRegNo;
    private String username;
    private Date dateFrom;
    private Date dateTo;
    private int navigation;
    private int childseat;
    private String firstName;
    private String lastName;
    private int age;
    private int price;
    private int insurance;
    private int status;

    private String navigationOption;
    private String childSeatOption;
    private String insuranceOption;
    private String reservationStatus;


    public Reservation(String reservationId, String carRegNo, String username, Date dateFrom, Date dateTo, int navigation, int childseat, String firstName, String lastName, int age, int price, int insurance, int status) {
        this.reservationId = reservationId;
        this.carRegNo = carRegNo;
        this.username = username;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.navigation = navigation;
        this.childseat = childseat;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.price = price;
        this.insurance = insurance;
        this.status = status;
        navigationOption = "no";
        childSeatOption = "no";
        insuranceOption = "no";
        reservationStatus = "not approved";

        if(childseat == 1){
            childSeatOption = "yes";
        }
        if(navigation == 1){
            navigationOption = "yes";
        }
        if(insurance == 1){
            insuranceOption = "Basic";
        } else if(insurance == 2){
            insuranceOption = "Medium";
        } else if(insurance == 3){
            insuranceOption = "Full Coverage";
        }

    }

    public String getReservationId() {
        return reservationId;
    }

    public String getCarRegNo() {
        return carRegNo;
    }

    public String getUsername() {
        return username;
    }

    public String getDateFrom() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateFrom);
        int yearFrom = calendar.get(Calendar.YEAR);
        int monthFrom = calendar.get(Calendar.MONTH) + 1;
        int dayFrom = calendar.get(Calendar.DAY_OF_MONTH);

        String str = yearFrom + "-" + monthFrom + "-" + dayFrom;

        return str;
    }

    public String  getDateTo() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateTo);
        int yearFrom = calendar.get(Calendar.YEAR);
        int monthFrom = calendar.get(Calendar.MONTH) + 1;
        int dayFrom = calendar.get(Calendar.DAY_OF_MONTH);

        String str = yearFrom + "-" + monthFrom + "-" + dayFrom;

        return str;
    }

    public Date getDateFromObject(){
        return dateFrom;
    }

    public Date getDateToObject(){
        return dateTo;
    }

    public int getNavigation() {
        return navigation;
    }

    public int getChildseat() {
        return childseat;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



    public int getAge() {
        return age;
    }

    public int getPrice() {
        return price;
    }

    public int getInsurance() {
        return insurance;
    }

    public int getStatus() {
        return status;
    }

    public String getNavigationOption() {
        return navigationOption;
    }

    public String getChildSeatOption() {
        return childSeatOption;
    }

    public String getInsuranceOption() {
        return insuranceOption;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public String toString(){
        return "Reservation. no.: " + reservationId + "|  "
                + "Car reg. no.: " + carRegNo + "|  "
                + "Username: " + username + "|  "
                + "Date from: " + getDateFrom() + "|  "
                + "Date to: : " + getDateTo() + "|  "
                + "Navigation: " + navigationOption + "|  "
                + "Child seat: " + childSeatOption + "|  "
                + "First name: " + firstName + "|  "
                + "Last name: " + lastName + "|  "
                + "Age: " + age + "|  "
                + "Price: " + price + "|  "
                + "Insurance: " + insuranceOption + "|  "
                + "Status: " + reservationStatus + "\n";
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Reservation))
            return false;

        Reservation other = (Reservation) obj;

        return reservationId.equals(other.getReservationId());
    }
}
