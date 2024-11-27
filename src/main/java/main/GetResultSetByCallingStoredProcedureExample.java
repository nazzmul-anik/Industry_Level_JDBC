package main;

import util.DatabaseUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

public class GetResultSetByCallingStoredProcedureExample {
    public static void main(String[] args) {
        String query = "CALL getAllEmployees()";
        try(
                Connection connection = DatabaseUtil.getConnection();
                CallableStatement callableStatement = connection.prepareCall(query);
                ResultSet resultSet = callableStatement.executeQuery();
                ){

            while(resultSet.next()){
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                double employee_salary = resultSet.getDouble("employee_salary");
                String employee_dept = resultSet.getString("employee_dept");
                Date employee_dob = resultSet.getDate("employee_dob");

                System.out.println(employee_id + "\t" + employee_name + "\t" + employee_salary + "\t" + employee_dept + "\t" +employee_dob);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
