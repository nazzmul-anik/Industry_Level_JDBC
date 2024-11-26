package util;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    public static Connection connection = null;

    static{
        try{
            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream(new File("src\\main\\resources\\db.properties"));
            properties.load(inputStream);
            String driverClassName = properties.getProperty("driver.class.name");
            String dbURL = properties.getProperty("db.url");
            String dbUserName = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");

            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        }catch(ClassNotFoundException | IOException | SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
