
import java.sql.*;
import java.io.*;
import student.JdbcConnection;

public class RetrieveImage {

    public static void main(String[] args) {
        try {
             Connection con=JdbcConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from imgtable");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {//now on 1st row  

                Blob b = rs.getBlob(2);//2 means 2nd column data  
                byte barr[] = b.getBytes(1, (int) b.length());//1 means first image  

                FileOutputStream fout = new FileOutputStream("D:\\Documents\\Achint docs\\scan2.jpg");
                fout.write(barr);

                fout.close();
            }//end of if  
            System.out.println("ok");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
