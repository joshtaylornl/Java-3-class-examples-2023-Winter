package ca.nl.cna.java3.jdbc;

import java.sql.*;

/**
 * Playing around with the Employee DB from Unit 2 Notes
 *
 * Use the following SQL to configure the database:
 *
 * <pre>
 * create table Employees ( Id int not null, age int not null, first varchar (255), last varchar (255) );
 * INSERT INTO Employees VALUES (100, 40, 'Albert', 'Norman');
 * INSERT INTO Employees VALUES (101, 42, 'Josh', 'Taylor');
 * INSERT INTO Employees VALUES (102, 41, 'Richard', 'Spencer');
 * INSERT INTO Employees VALUES (103, 58, 'Chris', 'Gash');
 * </pre>
 *
 * Note: All of this should be stored in the "employeedb" or change the DB_URL value
 *
 * @author Josh
 */
public class FunWithDBSelects {

    //Database parameters - "jdbc:mariadb" lets JDBC know to look for the Maria DB driver
    //TODO Make sure you port and password are set to you own values
    private static final String DB_URL = "jdbc:mariadb://localhost:3308/employeedb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "DXmE4JsCpvmZTQ";

    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "SELECT id, first, last, age FROM Employees";
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Employee data:");
            System.out.println("ID \t\tAGE \t\tFirst Name\t\t Last Name");
            while(resultSet.next()){
                // Retrieve by column name
                System.out.print(resultSet.getInt("id") + "\t\t");
                System.out.print(resultSet.getInt("age") + "\t\t\t");
                System.out.print(resultSet.getString("first") + "\t\t\t");
                System.out.println(resultSet.getString("last") + "\t\t");
            }

        } catch (SQLException sqlException){
            sqlException.printStackTrace();;
        }

    }

}
