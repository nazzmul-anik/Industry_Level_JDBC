package main;

import com.mysql.cj.protocol.Resultset;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class ReadDataFromDatabaseUsingStatement {
    public static void main(String[] args) {
        try(
                Connection connection = DatabaseUtil.getConnection();
                Statement statement = connection.createStatement();
                ){

            String query = "select *from employee";
            ResultSet resultset = statement.executeQuery(query);

            System.out.println("Employee ID \t Employee Name \t Employee Salary \t Employee Department \t Employee Date of birth");
            while (resultset.next()){
                int employee_id = resultset.getInt("employee_id");
                String employee_name = resultset.getString("employee_name");
                double employee_salary = resultset.getDouble("employee_salary");
                String employee_dept = resultset.getString("employee_dept");
                Date employee_dob = resultset.getDate("employee_dob");

                System.out.println(employee_id+" \t "+employee_name+" \t " + employee_salary + " \t " + employee_dept + " \t " + employee_dob);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
