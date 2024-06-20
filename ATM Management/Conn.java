/* 1 - Register the Driver
   2 - create connection
   3 - create statement
   4 - Execute query
   5 - close connection
*/
import java.sql.*;

class Conn {

    Statement s;  // 3rd step
    Connection c; // 2nd step

    public Conn(){  // we have to exception handling bcz mysql is an external entity
        try{
            c = DriverManager.getConnection("jdbc:mysql:///atm","root","Harshit@1308"); // driverManager-class | jdbc:mysql://localhost:3306 -- mysql mostly runs on localhost so no need to write   // connection
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
