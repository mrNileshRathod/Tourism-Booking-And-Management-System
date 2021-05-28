package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    
   public static Connection getConnection() throws SQLException, ClassNotFoundException
   {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/tourismmanagementsystem","root","");
        return con;
    }
}
