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

        try {
            //Check DBConfiguration Class if you have any issues with this connection
            Connection connection = DriverManager.getConnection(DBConfiguration.DB_URL, DBConfiguration.DB_USER, DBConfiguration.DB_PASSWORD);
            Statement statement = connection.createStatement();

            //TODO Add in a drop table command
            String sql = "CREATE DATABASE STUDENTS";
            statement.execute(sql);

            System.out.println("It worked!?");

            statement.close();
            connection.close();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();;
        }

    }

}
