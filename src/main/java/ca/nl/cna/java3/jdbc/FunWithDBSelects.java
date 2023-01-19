package ca.nl.cna.java3.jdbc;

import java.sql.*;

/**
 * Playing around with the Employee DB from Unit 2 Notes
 *
 * Use the following SQL to configure the database:
 *
 * Note: you can use "drop table Employees" to clean the db
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

    public static void main(String[] args) {

        try{
            //Check DBConfiguration Class if you have any issues with this connection
            Connection connection = DriverManager.getConnection(DBConfiguration.DB_URL + DBConfiguration.DB_EMPLOYEE_DB_NAME, DBConfiguration.DB_USER, DBConfiguration.DB_PASSWORD);
            printEmployeesTable(connection);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();;
        }

    }

    /**
     * Print out the employees table. This method is abstracted for reuse in other examples
     * @param connection open db connection
     */
    public static void printEmployeesTable(Connection connection){

        try{
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
            statement.close();
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();;
        }
    }


}
