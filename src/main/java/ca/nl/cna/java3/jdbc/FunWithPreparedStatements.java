package ca.nl.cna.java3.jdbc;

import java.sql.*;

/**
 * Use a prepared statement on the employee database
 *
 * @author Josh
 */
public class FunWithPreparedStatements {

    public static void main(String[] args) {

        //Check DBConfiguration Class if you have any issues with this connection
        try {
            Connection connection = DriverManager.getConnection(DBConfiguration.DB_URL + DBConfiguration.DB_EMPLOYEE_DB_NAME, DBConfiguration.DB_USER, DBConfiguration.DB_PASSWORD);
            //Print out database before
            FunWithDBSelects.printEmployeesTable(connection);

            String sql = "Update Employees SET age = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,33);
            preparedStatement.setInt(2,101);
            preparedStatement.executeUpdate();

            //Print out database after
            FunWithDBSelects.printEmployeesTable(connection);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}
