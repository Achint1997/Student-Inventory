/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculty;

import student.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import student.JdbcConnection;

public class Accounts_after_login extends JFrame implements ActionListener {

    JMenuBar mbar;
    JMenu m1, m2, m3, m4, m5;
    JMenuItem m_item1, m_item2, m_item3, m_item4, m_item5, m_item6, m_item7, m_item8, m_item9, m_item10, m_item11, m_item12;
    JLabel lb1, lb2, lb3;
    JLabel txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10;
    ResultSet res, res1;
    Statement stmt;
    public String aft_login = null, str_query = null;
    Connection con;

    public Accounts_after_login(String o) {
        con = JdbcConnection.getConnection();
        aft_login = o;
        System.out.println(aft_login);

        lb1 = new JLabel("YOUR PERSONAL DETAILS");
        lb1.setBounds(100, 10, 800, 50);
        lb1.setForeground(Color.cyan);
        lb1.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 40));
        add(lb1);
        mbar = new JMenuBar();
        m1 = new JMenu("PAYROLL");
        m_item1 = new JMenuItem("UPLOAD FEE STRUCTURE");
        m_item1.addActionListener(this);
        m1.add(m_item1);
        m5 = new JMenu("MORE");
        m_item10 = new JMenuItem("LOG OUT");
        m_item11 = new JMenuItem("EXIT");
        m_item10.addActionListener(this);
        m_item11.addActionListener(this);
        m5.add(m_item10);
        m5.add(m_item11);
        mbar.add(m1);
        mbar.add(m5);
        setJMenuBar(mbar);

        lb1 = new JLabel("COLLEGE ID NO.");
        lb1.setBounds(80, 130, 150, 30);
        add(lb1);
        lb1 = new JLabel("NAME");
        lb1.setBounds(80, 180, 150, 30);
        add(lb1);
        lb1 = new JLabel("DEPARTMENT");
        lb1.setBounds(80, 230, 150, 30);
        add(lb1);
        lb1 = new JLabel("DESIGNATION");
        lb1.setBounds(80, 280, 150, 30);
        add(lb1);
        lb1 = new JLabel("E-MAIL ID");
        lb1.setBounds(80, 330, 150, 30);
        add(lb1);
        lb1 = new JLabel("DATE OF BIRTH");
        lb1.setBounds(80, 380, 150, 30);
        add(lb1);
        lb1 = new JLabel("PERMANENT ADDRESS");
        lb1.setBounds(80, 430, 150, 30);
        add(lb1);
        lb1 = new JLabel("MOBILE NO.");
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
            String submit1 = "select * from account_registration where college_id='" + aft_login + "'";
            System.out.println(submit1);
            stmt = con.createStatement();
            res1 = stmt.executeQuery(submit1);
            while (res1.next()) {
                txt1.setText(res1.getString("college_id"));
                txt2.setText(res1.getString("name"));
                txt3.setText(res1.getString("department"));
                txt4.setText(res1.getString("designation"));
                txt5.setText(res1.getString("email_id"));
                str1 = res1.getString("date_of_birth");
                txt7.setText(res1.getString("permanent_address"));
                txt8.setText(res1.getString("mobile_no"));
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
        setTitle("ACCOUNTS'S PORTAL");
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
        if ("UPLOAD FEE STRUCTURE".equals(ae.getActionCommand())) {
            System.out.println(aft_login);
            new Payroll_upload(aft_login);
            dispose();
            
        }  else if ("LOG OUT".equals(ae.getActionCommand())) {
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
        new Accounts_after_login(rs);
    }*/
}
