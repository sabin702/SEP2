
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ManageDatabase {

        Connection c = null;
        Statement stmt = null;
   /*
        private String registration;
        private String make;
        private int mileage;
        private String color;
        private int year;
        private int availability;

    public ManageDatabase(Connection c, Statement stmt, String registration, String make, int mileage, String color, int year, int availability) {
        this.c = c;
        this.stmt = stmt;
        this.registration = registration;
        this.make = make;
        this.mileage = mileage;-
        this.color = color;
        this.year = year;
        this.availability = availability;
    }
*/

    public ManageDatabase() {
    }

    public void addCar(String registration, String make, int mileage, String color, int production, int availability){
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "password");

                System.out.println("Database open ok");

                stmt = c.createStatement();
                String sql = "INSERT INTO  \"SEP2\".car " + "VALUES('" + registration + "','" + make + "'," + mileage +",'" + color + "'," + production + "," + availability + ")";
                stmt.executeUpdate(sql);


                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database update ok");
        }

        public void deleteCar () {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "password");

                System.out.println("Database open ok");

                stmt = c.createStatement();
                String sql = "DELETE FROM \"SEP2\".car " + "WHERE registrationNumber = registration";
                stmt.executeUpdate(sql);


                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database update ok");
        }
        public void addCustomer () {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "password");

                System.out.println("Database open ok");

                stmt = c.createStatement();
                String sql = "INSERT INTO  \"SEP2\".Customer " + "VALUES  (login, passoword)";
                stmt.executeUpdate(sql);


                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database update ok");
        }
        public void deleteCustomer () {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "password");

                System.out.println("Database open ok");

                stmt = c.createStatement();
                String sql = "DELETE FROM \"SEP2\".Customer " + "WHERE login = log";
                stmt.executeUpdate(sql);


                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database update ok");
        }

        public void addEmployee() {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "password");

                System.out.println("Database open ok");

                stmt = c.createStatement();
                String sql = "INSERT INTO  \"SEP2\".Employee " + "VALUES  (login, passoword)";
                stmt.executeUpdate(sql);


                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database update ok");
        }
        public void deleteEmployee() {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "password");

                System.out.println("Database open ok");

                stmt = c.createStatement();
                String sql = "DELETE FROM \"SEP2\".Employee " + "WHERE login = log";
                stmt.executeUpdate(sql);


                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database update ok");
        }

        public void addReservation() {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "password");

                System.out.println("Database open ok");

                stmt = c.createStatement();
                String sql = "INSERT INTO  \"SEP2\".Reservation " + "VALUES  (reservationId, userLogin, dateFrom, dateTo, navigation, childSeat, name, surname, age)";
                stmt.executeUpdate(sql);


                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database update ok");
        }
        public void deleteReservation () {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "password");

                System.out.println("Database open ok");

                stmt = c.createStatement();
                String sql = "DELETE FROM \"SEP2\".Reservation " + "WHERE reservationID = reservID";
                stmt.executeUpdate(sql);


                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Database update ok");
        }

}





