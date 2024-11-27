package main;

import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteDataFromDatabaseUsingPreparedStatement {
    public static void main(String[] args) {
        String deleteQuery = "delete from employee where employee_id=?";

        try(
                Connection connection = DatabaseUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
                Scanner scanner = new Scanner(System.in);
                ){
            System.out.print("Please Enter Employee ID that you want to delete from database : ");
            int employee_id = scanner.nextInt();
            preparedStatement.setInt(1, employee_id);

            int execute = preparedStatement.executeUpdate();
            if(execute>0){
                System.out.println("Execute No : " + execute);
                System.out.println("Delete Data Successfully!!");
            }
            else{
                System.out.println("Execute No : " + execute);
                System.out.println("Employee ID = "+employee_id + " not found in database.");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
