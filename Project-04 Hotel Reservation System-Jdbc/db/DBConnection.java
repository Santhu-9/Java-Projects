package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection(){

        Connection con = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/hotel_db";
            String user = "root";
            String password = "password";

            con = DriverManager.getConnection(url,user,password);

            System.out.println("Connection successful");

        }catch(Exception e){

            e.printStackTrace();

        }

        return con;
    }
}
