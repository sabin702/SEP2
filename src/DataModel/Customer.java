package DataModel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    public String getDateOfBirth() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateOfBirth);
        int yearOfBirth = calendar.get(Calendar.YEAR);
        int monthOfBirth = calendar.get(Calendar.MONTH) + 1;
        int dayOfBirth = calendar.get(Calendar.DAY_OF_MONTH);

        String str = yearOfBirth + "-" + monthOfBirth + "-" + dayOfBirth;

        return str;
    }

    public Date getBirthDate(){
        return dateOfBirth;
    }

    public String toString(){
        return "Username: " + username
                + " Password: " + password;
    }

}
