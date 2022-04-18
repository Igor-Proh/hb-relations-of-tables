package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC_01_one_to_one_uni {
    public static void main(String[] args) {

        String jdbcUrl =
                "jdbc:mysql://localhost:3306/hb_01_one_to_one_uni?useSSL=false";
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
