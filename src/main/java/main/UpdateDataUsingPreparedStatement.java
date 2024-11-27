package main;

import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UpdateDataUsingPreparedStatement {
    public static void main(String[] args) {

        String updateQuery = "update employee set employee_salary=? where employee_id=?";

        try(
                Connection connection = DatabaseUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                ){

            preparedStatement.setDouble(1, 70000);
            preparedStatement.setInt(2, 3);

            int executed = preparedStatement.executeUpdate();
            if(executed>0) System.out.println("Update data successfully!!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
