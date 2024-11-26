package main;

import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ReadDataFromDatabaseUsingPreparedStatement {
    public static void main(String[] args) {

        String query = "select *from employee";

        try(
                Connection connection = DatabaseUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultset = preparedStatement.executeQuery();
                ){

            while(resultset.next()){
                int employee_id = resultset.getInt("employee_id");
                String employee_name = resultset.getString("employee_name");
                double employee_salary = resultset.getDouble("employee_salary");
                String employee_dept = resultset.getString("employee_dept");
                Date employee_dob = resultset.getDate("employee_dob");

                System.out.println(employee_id+"\t"+employee_name+"\t"+employee_salary+"\t"+employee_dept+"\t"+employee_dob);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
