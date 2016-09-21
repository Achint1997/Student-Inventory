package student;

import java.sql.*;

public class JdbcConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "fan_hawa");
            if (con == null) {
                System.out.println("connection failed");
            } else {
                System.out.println("connection establish");
            }
        } catch (Exception e) {
            System.out.println("error in class found " + e);
        }
        return con;
    }

    public static void main(String[] arg) {
        getConnection();
    }

}
