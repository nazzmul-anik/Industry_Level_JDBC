package main;

import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDataUsingJDBC_Batch {
    public static void main(String[] args) {
        String query = "update employee set employee_salary=? where employee_id=?";
        try(
                Connection connection = DatabaseUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ){
            double newSalary = 35000;
            int employee_id = 1;

            preparedStatement.setDouble(1, newSalary);
            preparedStatement.setInt(2, employee_id);
            preparedStatement.addBatch();

            newSalary = 50000;
            employee_id = 7;

            preparedStatement.setDouble(1, newSalary);
            preparedStatement.setInt(2, employee_id);
            preparedStatement.addBatch();

            newSalary = 15000;
            employee_id = 5;

            preparedStatement.setDouble(1, newSalary);
            preparedStatement.setInt(2, employee_id);
            preparedStatement.addBatch();

            int[] executeBatch = preparedStatement.executeBatch();
            for(int execution : executeBatch){
                System.out.println(execution);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
