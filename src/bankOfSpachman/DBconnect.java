/**
 * 
 * 
 * @author user
 */
package bankOfSpachman;
import java.sql.*;

public class DBconnect {
    private Connection con;
    private Statement stmt;
    ResultSet rs;
    
    public DBconnect() {
        String url = "jdbc:mysql://localhost:3306/tables";
        String user = "root";
        String password = "Ft&gbish1";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("here");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("connected");
        }
        catch(Exception e) {System.out.println("damn it");}
    }
    
    public static void main(String [ ] args) {
        DBconnect connection = new DBconnect();
    }
}