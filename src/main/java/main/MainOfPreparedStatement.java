package main;

import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class MainOfPreparedStatement {
    public static void main(String[] args) {

        String insertQuery = "insert into employee (employee_name, employee_salary, employee_dept, employee_dob) values (?, ?, ?, ?)";
        try(Connection connection = DatabaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);){

            preparedStatement.setString(1, "Zim");
            preparedStatement.setDouble(2, 30000);
            preparedStatement.setString(3,"Electronics Engineer");
            preparedStatement.setObject(4, LocalDate.of(2011, 6, 17));
            int execute = preparedStatement.executeUpdate();
            if(execute>0){
                System.out.println(execute);
                System.out.println("Data are saved successfully!!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
