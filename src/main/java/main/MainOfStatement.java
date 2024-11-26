package main;

import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.Statement;


public class MainOfStatement {
    public static void main(String[] args) {

        try(Connection connection = DatabaseUtil.getConnection(); Statement statement = connection.createStatement();){
            String insertQuery = "insert into employee (employee_name, employee_salary, employee_dept, employee_dob) values ('Mim', 72400, 'UI/UX Designer', '2007-05-18')";
//            boolean execute = statement.execute(insertQuery);
            int execute = statement.executeUpdate(insertQuery);
            if(execute>0){
                System.out.println(execute);
                System.out.println("Data saved successfully !!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
