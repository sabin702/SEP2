package shared.DataModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Customer implements Serializable {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public Customer(String username, String password, String firstName, String lastName, Date dateOfBirth) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate(){
        return dateOfBirth;
    }

    public String toString(){
        return "Username: " + username
                + " Password: " + password;
    }

    public int getNumberOfDays(Date date1, Date date2){
        long difference = Math.abs(date2.getTime() - date1.getTime());
        int days = (int) (difference / (1000 * 60 * 60 * 24));
        return days;
    }

    public int getAge(){
        LocalDate localDate = LocalDate.now();
        Date today = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return (getNumberOfDays(today, dateOfBirth)/365);
    }

}