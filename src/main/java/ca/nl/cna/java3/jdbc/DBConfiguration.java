package ca.nl.cna.java3.jdbc;

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

    //TODO update this to use the right URL and Port
    protected static final String DB_URL = "jdbc:mariadb://localhost:3308";
    //TODO update this for the appropriate login
    protected static final String DB_USER = "root";
    protected static final String DB_PASSWORD = "DXmE4JsCpvmZTQ";

    //Example specific references
    protected static final String DB_EMPLOYEE_DB_NAME = "/employeedb";
    //TODO include the employee column ID's and update other classes

}
