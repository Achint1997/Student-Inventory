
import java.sql.*;
import java.io.*;
import student.JdbcConnection;

public class InsertImage {

    public static void main(String[] args) {
        try {
            Connection con=JdbcConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into imgtable values(?,?)");
            ps.setString(1, "sonoo");

            FileInputStream fin = new FileInputStream("D:\\Documents\\Achint docs\\scan2.jpg");
            ps.setBinaryStream(2, fin, fin.available());
            int i = ps.executeUpdate();
            System.out.println(i + " records affected");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
