package ca.nl.cna.java3.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A class to store all your DB Related parameters.
 *
 * If you adjust this for you specific database all the examples should work
 *
 * Note: This is for ease of examples. In production code you would NEVER
 * store a root password like this!
 *
 * @author Josh
 */
public class DBConfiguration {

    protected static final String MARIA_DB_DRIVER_NAME = "org.mariadb.jdbc.Driver";

    //TODO For Students - update this to use the right URL and Port
    protected static final String DB_URL = "jdbc:mariadb://localhost:3308";
    //TODO For Students - update this for the appropriate login
    protected static final String DB_USER = "root";
    protected static final String DB_PASSWORD = "DXmE4JsCpvmZTQ";

    //Example specific references
    protected static final String DB_EMPLOYEE_DB_NAME = "/employeedb";
    protected static final String DB_EMPLOYEE_COL_FIRST_NAME = "first";
    protected static final String DB_EMPLOYEE_COL_LAST_NAME = "last";
    protected static final String DB_EMPLOYEE_COL_AGE = "age";
    protected static final String DB_EMPLOYEE_COL_ID = "id";

    /**
     * Register a driver using Java's Class.forName() method
     * to dynamically load the driver's class file into memory
     * which automatically registers it.
     */
    public static void doClassForNameRegistration(){
        try {
            Class.forName(DBConfiguration.MARIA_DB_DRIVER_NAME);
            System.out.println("DB Driver Registration using Class.forName() worked! (Option 1)");
        }
        catch(ClassNotFoundException ex) {
            System.err.println("ClassNotFoundException: unable to load MariaDB driver class!");
            System.err.println("Driver name: " + DBConfiguration.MARIA_DB_DRIVER_NAME);
            System.exit(1);
        }
    }

    /**
     * Register the driver using registerDriver() method. This is the 2nd and less preferred option
     * noted in the Unit 2 notes.
     */
    public static void doRegisterDriverMethodRegistration(){
        try {
            Driver myDriver = new org.mariadb.jdbc.Driver();
            DriverManager.registerDriver( myDriver );
            System.out.println("DB Driver Registration using registerDriver() worked! (Option 2)");
        }
        catch (SQLException e) {
            System.err.println("SQL Exception: trying to register MariaDB Driver");
            e.printStackTrace();
        }
    }

}
