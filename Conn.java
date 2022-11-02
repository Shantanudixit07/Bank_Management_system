package BankManagementSystem;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {
            c = DriverManager.getConnection("jdbc:mysql:///BankManagementSystem" ,"root","yash@24");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }


}
