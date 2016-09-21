package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JLabel;

public class After_Login_window extends JFrame implements ActionListener {

    JMenuBar mbar;
    JMenu m1, m2, m3, m4, m5;
    JMenuItem m_item1, m_item2, m_item3, m_item4, m_item5, m_item6, m_item7, m_item8, m_item9, m_item10, m_item11, m_item12, m_item13;
    JLabel lb1, lb2, lb3;
    JLabel txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10;
    ResultSet res, res1;
    Statement stmt;
    public String aft_login = null, str_query = null;
    Connection con;

    public After_Login_window(String o) {
        con = JdbcConnection.getConnection();

        aft_login = o;
        System.out.println(aft_login);

        lb1 = new JLabel("STUDENT'S PERSONAL DETAILS");
        lb1.setBounds(100, 10, 800, 50);
        lb1.setForeground(Color.GRAY);
        lb1.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 40));
        add(lb1);

        mbar = new JMenuBar();

        m1 = new JMenu("ACADEMICS");
        m_item1 = new JMenuItem("SUBJECTS");
        m_item2 = new JMenuItem("ASSIGNMENTS");
        m_item3 = new JMenuItem("ATTENDANCE");
        m_item4 = new JMenuItem("LECTURES");
        m_item1.addActionListener(this);
        m_item2.addActionListener(this);
        m_item3.addActionListener(this);
        m_item4.addActionListener(this);
        m1.add(m_item1);
        m1.add(m_item2);
        m1.add(m_item3);
        m1.add(m_item4);

        m2 = new JMenu("EXTRA CURRICULAR");
        m_item6 = new JMenuItem("SPORTS");
        m_item6.addActionListener(this);
        m2.add(m_item6);

        m3 = new JMenu("ACCOUNTS");
        m_item7 = new JMenuItem("PAYROLL");
        m_item7.addActionListener(this);
        m3.add(m_item7);

        m4 = new JMenu("HELP");
        m_item8 = new JMenuItem("LEAVE");
        m_item9 = new JMenuItem("GRIEVANCES");
        m_item12 = new JMenuItem("LEAVE STATUS");
        m_item13 = new JMenuItem("GRIEVANCES STATUS");
        m_item12.addActionListener(this);
        m_item13.addActionListener(this);
        m_item9.addActionListener(this);
        m_item8.addActionListener(this);
        m4.add(m_item8);
        m4.add(m_item9);
        m4.add(m_item12);
        m4.add(m_item13);

        m5 = new JMenu("MORE");
        m_item10 = new JMenuItem("LOG OUT");
        m_item11 = new JMenuItem("EXIT");
        m_item10.addActionListener(this);
        m_item11.addActionListener(this);
        m5.add(m_item10);
        m5.add(m_item11);

        mbar.add(m1);
        mbar.add(m2);
        mbar.add(m3);
        mbar.add(m4);
        mbar.add(m5);
        setJMenuBar(mbar);

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
        String str1 = "    -  -  ";
        try {
            String submit1 = "select * from student_registration where roll_no='" + aft_login + "'";
            System.out.println(submit1);
            stmt = con.createStatement();
            res1 = stmt.executeQuery(submit1);
            while (res1.next()) {
                txt1.setText(res1.getString("name"));
                txt2.setText(res1.getString("roll_no"));
                txt3.setText(res1.getString("branch"));
                txt4.setText(res1.getString("semester"));
                txt5.setText(res1.getString("student_email_id"));
                str1 = res1.getString("date_of_birth");
                txt7.setText(res1.getString("permanent_address"));
                txt8.setText(res1.getString("student_mobile_no"));
            }
        } catch (Exception ex) {
        }

        String string = new String();
        int i;
        for (i = 9; str1.charAt(i) != '-'; i--) {
            string = str1.charAt(i) + string;
        }
        string = string + "-";
        for (i = 5; str1.charAt(i) != '-'; i++) {
            string = string + str1.charAt(i);
        }
        string = string + "-";
        for (i = 0; str1.charAt(i) != '-'; i++) {
            string = string + str1.charAt(i);
        }
        txt6.setText(string);

        setLayout(null);
        setTitle("WELCOME TO STUDENT PORTAL");
        setBounds(30, 30, 750, 650);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#bdb76b"));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public void actionPerformed(ActionEvent ae) {
        if ("SUBJECTS".equals(ae.getActionCommand())) {
            System.out.println(aft_login);
            new Subjects(aft_login);
            dispose();
        } else if ("ASSIGNMENTS".equals(ae.getActionCommand())) {
            System.out.println(aft_login);
            new Assignments(aft_login);
            dispose();
        } else if ("ATTENDANCE".equals(ae.getActionCommand())) {
            System.out.println(aft_login);
            new Attendance(aft_login);
            dispose();

        } else if ("LECTURES".equals(ae.getActionCommand())) {
            new Lectures(aft_login);
            dispose();
        } else if ("SPORTS".equals(ae.getActionCommand())) {
            new Sports(aft_login);
            dispose();
        } else if ("PAYROLL".equals(ae.getActionCommand())) {
            new Payroll_download(aft_login);
            dispose();
        } else if ("LEAVE".equals(ae.getActionCommand())) {
            new Leave(aft_login);
            dispose();
        } else if ("LEAVE STATUS".equals(ae.getActionCommand())) {
            System.out.println(aft_login);
            new Leave_status(aft_login);
            dispose();
        } else if ("GRIEVANCES STATUS".equals(ae.getActionCommand())) {
            System.out.println(aft_login);
            new Grievances_status(aft_login);
            dispose();
        } else if ("GRIEVANCES".equals(ae.getActionCommand())) {
            new Grievances(aft_login);
            dispose();

        } else if ("LOG OUT".equals(ae.getActionCommand())) {
            aft_login = null;
            new project_login();
            dispose();

        } else if ("EXIT".equals(ae.getActionCommand())) {
            aft_login = null;
            System.exit(0);
        }
    }
/*
    public static void main(String[] arg) {
        String rs = null;
        new After_Login_window(rs);
    }*/
}
