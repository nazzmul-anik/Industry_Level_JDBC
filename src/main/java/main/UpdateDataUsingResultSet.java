package main;

import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateDataUsingResultSet {
    public static void main(String[] args) {
        String query = "select *from employee";
        try(
                Connection connection = DatabaseUtil.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = preparedStatement.executeQuery();
                Scanner scanner = new Scanner(System.in);
                ){
            System.out.print("Enter Employee ID, that you want to update : ");
            int employee_id = scanner.nextInt();
            System.out.print("Enter Updatable Salary of "+employee_id+" No Employee = ");
            double employee_new_salary = scanner.nextDouble();

            while(resultSet.next()){
                if(resultSet.getInt("employee_id") == employee_id){
                    resultSet.updateDouble("employee_salary", employee_new_salary);
                    resultSet.updateRow();
                    System.out.println("Update Salary Successfully!!");
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
