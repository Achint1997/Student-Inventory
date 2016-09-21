/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import faculty.Accounts_after_login;
import faculty.Faculty_after_login;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class project_login extends JFrame implements ActionListener {

    JLabel lb1, lb2, lb3, lb4;
    JTextField txt1, txt2, txt3, txt4;
    JButton btn1;
    JComboBox cb1;
    Statement stmt, stmt1;
    ResultSet res, res1;
    Connection con;
    JPasswordField pf;
    public String id = null;
    int i = 1;

    public project_login() {
        con = JdbcConnection.getConnection();

        lb1 = new JLabel("ROLL NO./COLLEGE ID");
        lb1.setBounds(50, 50, 300, 40);
        add(lb1);
        lb3 = new JLabel("PASSWORD");
        lb3.setBounds(50, 100, 100, 40);
        add(lb3);
        lb4 = new JLabel("DEPARTMENT");
        lb4.setBounds(50, 150, 100, 40);
        add(lb4);
        lb2 = new JLabel();
        lb2.setBounds(125, 200, 200, 40);
        add(lb2);

        txt1 = new JTextField();
        txt1.setBounds(200, 50, 200, 40);
        add(txt1);

        pf = new JPasswordField();
        pf.setColumns(20);
        pf.setBounds(200, 100, 200, 40);
        add(pf);

        cb1 = new JComboBox();
        cb1.setBounds(200, 150, 200, 40);
        cb1.addItem("SELECT");
        cb1.addItem("STUDENT");
        cb1.addItem("FACULTY");
        cb1.addItem("ACCOUNTS OFFICE");
        add(cb1);

        btn1 = new JButton("Login");
        btn1.setBounds(125, 230, 100, 40);
        add(btn1);
        btn1.addActionListener(this);

        btn1 = new JButton("BACK");
        btn1.setBounds(0, 0, 100, 20);
        add(btn1);
        btn1.addActionListener(this);

        setTitle("LOGIN");
        setLayout(null);
        setBounds(400, 150, 500, 500);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                return;
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if ("Login".equals(e.getActionCommand()) && "STUDENT".equals(cb1.getSelectedItem())) {
            try {
                String string = new String(pf.getPassword());
                con = JdbcConnection.getConnection();
                stmt = con.createStatement();
                String login = "select * from studentlogin where username='"+txt1.getText()+"'",str1 = null;
                res = stmt.executeQuery(login);
                while (res.next()) {
                    str1 = res.getString("password");
                }
                System.out.println(str1);
                if (str1.equals(string)) {
                    new After_Login_window(txt1.getText());
                    dispose();

                } else {
                    lb2.setText("WRONG PASSWORD/ROLL NO.");
                }

            } catch (Exception ex) {
                lb2.setText("WRONG DEPARTMENT ENTERED");
                System.out.println(ex);
            }

        } else if ("Login".equals(e.getActionCommand()) && "FACULTY".equals(cb1.getSelectedItem())) {
            try {
                String pass = new String(pf.getPassword());
                String login_f = "select * from facultylogin where username='"+txt1.getText()+"'", str1 = null, str2 = null;
                stmt = con.createStatement();
                res1 = stmt.executeQuery(login_f);
                System.out.println(login_f);
                while (res1.next()) {
                    str1 = res1.getString("username");
                    str2 = res1.getString("password");
                }
                if (str1.equals(txt1.getText()) && str2.equals(pass)) {
                    new Faculty_after_login(str1);
                    dispose();
                } else {
                    lb2.setText("WRONG PASSWORD/COLLEGE ID");
                }
            } catch (Exception ex) {
                lb2.setText("WRONG DEPARTMENT ENTERED");
                System.out.println(ex);

            }
        }
            else if ("Login".equals(e.getActionCommand()) && "ACCOUNTS OFFICE".equals(cb1.getSelectedItem())) {
            try {
                String pass = new String(pf.getPassword());
                String login_f = "select * from accountlogin", str1 = null, str2 = null;
                stmt = con.createStatement();
                res1 = stmt.executeQuery(login_f);
                System.out.println(login_f);
                while (res1.next()) {
                    str1 = res1.getString("username");
                    str2 = res1.getString("password");
                }
                if (str1.equals(txt1.getText()) && str2.equals(pass)) {
                    new Accounts_after_login(str1);
                    dispose();
                } else {
                    lb2.setText("WRONG PASSWORD/COLLEGE ID");
                }

            } catch (Exception ex) {
                lb2.setText("WRONG DEPARTMENT ENTERED");
                System.out.println(ex);

            }
        } else if ("BACK".equals(e.getActionCommand())) {
            new main();
            dispose();
        }
    }

    public static void main(String[] arg) {
        new project_login();
    }

}
