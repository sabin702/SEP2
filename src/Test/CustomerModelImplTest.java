package Test;

import MVVM.Model.Customer.CustomerModelImpl;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class CustomerModelImplTest {

    @Test
    public void getNumberOfDays() {
        Date dateFrom = new GregorianCalendar(2019, Calendar.JUNE, 28).getTime();
        Date dateTo  = new GregorianCalendar(2019, Calendar.JUNE, 30).getTime();
        assertEquals(2, new CustomerModelImpl().getNumberOfDays(dateFrom, dateTo));
    }

    @Test
    public void calculateTotalPrice() {
        String insurance = "Basic (25 DKK/day)";
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = date1.plus(3, ChronoUnit.DAYS);
        int carPrice = 300;
        int navPrice = 50;
        int csPrice = 75;
        //(300+50+75+25) * 3 = 450 * 3 = 1350;
        assertEquals(1350, new CustomerModelImpl().calculateTotalPrice(insurance, date1, date2, carPrice, navPrice, csPrice));
        insurance = "Medium (50 DKK/day)";
        date1 = LocalDate.of(2019, Month.JUNE, 01);
        date2 = LocalDate.of(2019, Month.JUNE, 07);
        carPrice = 200;
        navPrice = 50;
        csPrice = 75;
        //(200 + 50 + 75 + 50) * 6 = 375 * 6 = 2250
        assertNotEquals(0, new CustomerModelImpl().calculateTotalPrice(insurance, date1, date2, carPrice, navPrice, csPrice));
        insurance = "Full Coverage (100 DKK/day)";
        date1 = LocalDate.of(2019, Month.JUNE, 05);
        date2 = LocalDate.of(2019, Month.JULY, 20);
        carPrice = 400;
        navPrice = 50;
        csPrice = 75;
        //(400 + 50 + 75 + 100) * 45 = 625 * 45 = 28125
        assertEquals(28125, new CustomerModelImpl().calculateTotalPrice(insurance, date1, date2, carPrice, navPrice, csPrice));
    }
}