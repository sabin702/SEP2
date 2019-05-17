
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ManageDatabase {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        public void addCar () {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "PASSWORD");

                System.out.println("Database open ok");

                stmt = c.createStatement();
                String sql = "INSERT INTO  \"SEP2\".car " + "VALUES  (registration,make,mileage,color,production,availability)";
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
                                "postgres", "PASSWORD");

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
                                "postgres", "PASSWORD");

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
                                "postgres", "PASSWORD");

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

        public void addEmployee () {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "PASSWORD");

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
        public void deleteEmployee () {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "PASSWORD");

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

        public void addReservation () {
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "postgres", "PASSWORD");

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
                                "postgres", "PASSWORD");

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
}




