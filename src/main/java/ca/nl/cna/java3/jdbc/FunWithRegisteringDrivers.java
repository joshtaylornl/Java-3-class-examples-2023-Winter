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
        DBConfiguration.doClassForNameRegistration();
        DBConfiguration.doRegisterDriverMethodRegistration();
    }



}
