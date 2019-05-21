package database;

import java.sql.*;

public class Select {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM \"SEP2\".car";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String registrationNumber = rs.getString("registrationNumber");
                String make = rs.getString("name");
                int mileage = rs.getInt("mileage");
                String color = rs.getString("color");
                int productionYear = rs.getInt("model_year");
                int availability = rs.getInt("availability");

                //Display values
                System.out.print("Reg. no.: " + registrationNumber + "|  ");
                System.out.print("Make: " + make + "|  ");
                System.out.print("Mileage: " + mileage + "|  ");
                System.out.print("Color: " + color + "|  ");
                System.out.print("Prod. year: " + productionYear + "|  ");
                switch (availability){
                    case 0:
                        System.out.print("Status: unavailable");
                        break;
                    case 1:
                        System.out.print("Status: available");
                        break;
                    default:
                        System.out.print("Status: No status");
                }
                System.out.println("");
            }
            rs.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main

}
