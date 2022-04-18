package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC_05_many_to_many {
    public static void main(String[] args) {

        String jdbcUrl =
                "jdbc:mysql://localhost:3306/hb_05_many_to_many?useSSL=false";
        String user = "bestuser";
        String pass = "bestuser";

        try{
            System.out.println("Connecting to database " + jdbcUrl);
            Connection myConn =
                    DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection succesfull !!!");

        }catch(Exception exception){
            exception.printStackTrace();

        }

    }
}
