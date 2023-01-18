package ca.nl.cna.java3.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Playing around with Database Creation. This example is from the Unit 2 notes.
 *
 * @author Josh
 */
public class FunWithDBCreation {

    //Database parameters - "jdbc:mariadb" lets JDBC know to look for the Maria DB driver
    //TODO Make sure you port and password are set to you own values
    private static final String DB_URL = "jdbc:mariadb://localhost:3308/";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "DXmE4JsCpvmZTQ";

    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE STUDENTS";
            statement.execute(sql);

            System.out.println("It worked!?");

        } catch (SQLException sqlException){
            sqlException.printStackTrace();;
        }

    }

}
