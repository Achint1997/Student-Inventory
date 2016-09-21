package student;
/*
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

public class Personal_details extends JFrame implements ActionListener {

    JLabel lb1, lb2, lb3;
    JLabel txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10;
    JButton btn;
    Connection con;
    Statement stmt;
    ResultSet res;

    public Personal_details(ResultSet o) {
        res=o;
        lb1 = new JLabel("NAME");
        lb1.setBounds(80, 130, 150, 30);
        add(lb1);
        lb1 = new JLabel("ROLL NO.");
        lb1.setBounds(80, 180, 150, 30);
        add(lb1);
        lb1 = new JLabel("BRANCH");
        lb1.setBounds(80, 230, 150, 30);
        add(lb1);
        lb1 = new JLabel("SEMESTER");
        lb1.setBounds(80, 280, 150, 30);
        add(lb1);
        lb1 = new JLabel("STUDENT E-MAIL ID");
        lb1.setBounds(80, 330, 150, 30);
        add(lb1);
        lb1 = new JLabel("DATE OF BIRTH");
        lb1.setBounds(80, 380, 150, 30);
        add(lb1);
        lb1 = new JLabel("PERMANENT ADDRESS");
        lb1.setBounds(80, 430, 150, 30);
        add(lb1);
        lb1 = new JLabel("STUDENT MOBILE");
        lb1.setBounds(80, 480, 150, 30);
        add(lb1);

        txt1 = new JLabel();
        txt1.setBounds(400, 130, 300, 30);
        add(txt1);
        txt2 = new JLabel();
        txt2.setBounds(400, 180, 300, 30);
        add(txt2);
        txt3 = new JLabel();
        txt3.setBounds(400, 230, 300, 30);
        add(txt3);
        txt4 = new JLabel();
        txt4.setBounds(400, 280, 300, 30);
        add(txt4);
        txt5 = new JLabel();
        txt5.setBounds(400, 330, 300, 30);
        add(txt5);
        txt6 = new JLabel();
        txt6.setBounds(400, 380, 300, 30);
        add(txt6);
        txt7 = new JLabel();
        txt7.setBounds(400, 430, 300, 30);
        add(txt7);
        txt8 = new JLabel();
        txt8.setBounds(400, 480, 300, 30);
        add(txt8);
        try {
            while (res.next()) {
                txt1.setText(res.getString("name"));
                txt2.setText(res.getString("roll_no"));
                txt3.setText(res.getString("branch"));
                txt4.setText(res.getString("semester"));
                txt5.setText(res.getString("student_email_id"));
                txt6.setText(res.getString("date_of_birth"));
                txt7.setText(res.getString("permanent_address"));
                txt8.setText(res.getString("student_mobile_no"));
            }
        } catch (Exception ex) {
        }
        btn = new JButton("BACK");
        btn.setBounds(0, 0, 80, 20);
        add(btn);
        btn.addActionListener(this);

        setTitle("MY PERSONAL DETAILS");
        setLayout(null);
        setBounds(10, 10, 1300, 720);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent we) {
                return;
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if ("OK".equals(ae.getActionCommand())) {
            new After_Login_window(res);
            dispose();
        } else if ("BACK".equals(ae.getActionCommand())) {
            new After_Login_window(res);
            dispose();
        }
    }

    public static void main(String[] arg) {
        ResultSet res=null;
        new Personal_details(res);
        
    }
}
*/