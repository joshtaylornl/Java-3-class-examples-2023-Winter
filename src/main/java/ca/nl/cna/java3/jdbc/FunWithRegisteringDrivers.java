package ca.nl.cna.java3.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Exploring the two types of driver registration from Unit 2 notes
 *
 * @author Josh
 */
public class FunWithRegisteringDrivers {

    public static void main(String[] args) {
        doClassForNameRegistration();
        doRegisterDriverMethodRegistration();
    }

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
