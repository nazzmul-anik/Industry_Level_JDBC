package main;

import util.DatabaseUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

public class CallingStoredProcedureExample {
    public static void main(String[] args) {

        String query = "CALL getEmployeeNameAndSalaryById(?, ?, ?)";
        try(
                Connection connection = DatabaseUtil.getConnection();
                CallableStatement callableStatement = connection.prepareCall(query);
                Scanner scanner = new Scanner(System.in);
                ){

            System.out.print("Enter Employee ID : ");
            int employee_id = scanner.nextInt();

            callableStatement.setInt(1, employee_id);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.registerOutParameter(3, Types.DOUBLE);

            int result = callableStatement.executeUpdate();

            if(result>0){
                System.out.println("Employee Id = " + employee_id);
                System.out.println("Employee Name = " + callableStatement.getString("empName"));
                System.out.println("Employee Salary = " + callableStatement.getDouble("empSal"));

            }else{
                System.out.println("Employee Id = " + employee_id + " is not found in database.");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
