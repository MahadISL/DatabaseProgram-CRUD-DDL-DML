import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static String url = "jdbc:mysql://localhost:3306/mysqljdbc";
    private static String username = "root";
    private static String password = "QWERTY@1";
    private static Connection con = null;

    // Static method to create/return instance for Connection

    public DBUtils() throws SQLException {
    }

    public static Connection getConnection() throws SQLException {
        if (con == null){
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");
            DBUtils.con = con;
            return con;
        }
        System.out.println("Connection is already established");
        return con;
    }

    public void closeConnection() throws SQLException {
        con.close(); // close connection
        con = null;
        System.out.println("Connection Closed....");
    }

}
