package student;

import javax.swing.*;
import java.awt.event.*;
import faculty.*;
import java.awt.Color;
import java.sql.*;

public class Sign_up extends JFrame implements ActionListener, ItemListener {

    JLabel lb1, lb2, lb3, lb4;
    JTextField txt1, txt2, txt3, txt4;
    JButton btn1;
    JComboBox cb1;
    Statement stmt;
    ResultSet res;
    Connection con;
    JPasswordField pf;

    public Sign_up() {
        con = JdbcConnection.getConnection();

        lb1 = new JLabel("ROLL NO./COLLEGE ID");
        lb1.setBounds(50, 50, 100, 40);
        add(lb1);
        lb2 = new JLabel("E-MAIL");
        lb2.setBounds(50, 100, 100, 40);
        add(lb2);
        lb3 = new JLabel("PASSWORD");
        lb3.setBounds(50, 150, 100, 40);
        add(lb3);
        lb4 = new JLabel("DEPARTMENT");
        lb4.setBounds(50, 200, 100, 40);
        add(lb4);

        txt1 = new JTextField();
        txt1.setBounds(200, 50, 200, 40);
        add(txt1);
        txt2 = new JTextField();
        txt2.setBounds(200, 100, 200, 40);
        add(txt2);

        pf = new JPasswordField();
        pf.setColumns(20);
        pf.setBounds(200, 150, 200, 40);
        add(pf);

        cb1 = new JComboBox();
        cb1.setBounds(200, 200, 200, 40);
        cb1.addItem("SELECT");
        cb1.addItem("STUDENT");
        cb1.addItem("FACULTY");
        cb1.addItem("ACCOUNTS");
        add(cb1);
        cb1.addItemListener(this);

        btn1 = new JButton("SIGN UP");
        btn1.setBounds(125, 280, 100, 30);
        add(btn1);
        btn1.addActionListener(this);

        btn1 = new JButton("BACK");
        btn1.setBounds(0, 0, 100, 20);
        add(btn1);
        btn1.addActionListener(this);

        setTitle("Sign Up");
        setLayout(null);
        setBounds(50, 50, 500, 500);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                return;
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if ("SIGN UP".equals(e.getActionCommand()) && "STUDENT".equals(cb1.getSelectedItem())) {
            try {
                String string = new String(pf.getPassword());
                new Student_registration(txt1.getText(), txt2.getText(), string);
                dispose();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if ("SIGN UP".equals(e.getActionCommand()) && "FACULTY".equals(cb1.getSelectedItem())) {
            try {
                String string = new String(pf.getPassword());
                new Faculty_registration(txt1.getText(), txt2.getText(), string);
                dispose();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if ("BACK".equals(e.getActionCommand())) {
            main m = new main();
            dispose();
        }else if ("SIGN UP".equals(e.getActionCommand()) && "ACCOUNTS".equals(cb1.getSelectedItem())) {
            try {
                String string = new String(pf.getPassword());
                new Accounts_registration(txt1.getText(), txt2.getText(), string);
                dispose();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {

    }
/*
    public static void main(String[] arg) {
        new Sign_up();

    }*/
}
