package faculty;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.Border;
import student.JdbcConnection;
import student.project_login;

public class Faculty_registration extends JFrame implements ActionListener, ItemListener {

    JLabel lb1;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7;
    JTextArea ta4;
    JComboBox cb1, cb2;
    JRadioButton rd1, rd2;
    JButton btn;
    ButtonGroup bg1;
    Connection con;
    Statement stmt;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    public String tex1 = null, tex2 = null, pass = null;

    public Faculty_registration(String text1, String text2, String str) {
        con = JdbcConnection.getConnection();
        tex1 = text1;
        tex2 = text2;
        pass = str;
        //JOptionPane.showConfirmDialog(this, "ONE PENDING LEAVE");
        lb1 = new JLabel("FACULTY REGISTRATION");
        lb1.setBackground(Color.cyan);
        lb1.setBounds(100, 20, 500, 50);
        lb1.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 30));
        add(lb1);
        lb1 = new JLabel("COLLEGE ID");
        lb1.setBounds(30, 130, 150, 30);
        add(lb1);
        lb1 = new JLabel("NAME");
        lb1.setBounds(30, 180, 150, 30);
        add(lb1);
        lb1 = new JLabel("DEPARTMENT");
        lb1.setBounds(30, 230, 150, 30);
        add(lb1);
        lb1 = new JLabel("DESIGNATION");
        lb1.setBounds(30, 280, 150, 30);
        add(lb1);
        lb1 = new JLabel("E-MAIL ID");
        lb1.setBounds(30, 330, 150, 30);
        add(lb1);
        lb1 = new JLabel("GENDER");
        lb1.setBounds(30, 380, 150, 30);
        add(lb1);
        lb1 = new JLabel("PERMANENT ADDRESS");
        lb1.setBounds(30, 430, 150, 30);
        add(lb1);
        lb1 = new JLabel("MOBILE NO.");
        lb1.setBounds(30, 480, 150, 30);
        add(lb1);
        lb1 = new JLabel("DATE OF BIRTH");
        lb1.setBounds(30, 530, 150, 30);
        add(lb1);
        txt1 = new JTextField();
        txt1.setBounds(200, 130, 200, 30);
        txt1.setBorder(border);
        add(txt1);
        txt2 = new JTextField();
        txt2.setBounds(200, 180, 200, 30);
        txt2.setBorder(border);
        add(txt2);
        cb1 = new JComboBox();
        cb1.setBounds(200, 230, 200, 30);
        cb1.setBorder(border);
        cb1.addItem("SELECT DEPARTMENT");
        cb1.addItem("CHEMICAL ENGINEERING");
        cb1.addItem("CIVIL ENGINEERING");
        cb1.addItem("COMPUTER SCIENCE ");
        cb1.addItem("ELECTRICAL ENGINEERING");
        cb1.addItem("ELECTRONICS ENGINEERING");
        cb1.addItem("MECHANICAL ENGINEERING");
        cb1.addItemListener(this);
        add(cb1);
        cb2 = new JComboBox();
        cb2.setBounds(200, 280, 200, 30);
        cb2.setBorder(border);
        cb2.addItem("SELECT DESIGNATION");
        cb2.addItem("DEAN OF STUDENT WELFARE");
        cb2.addItem("DEAN OF ACADEMICS");
        cb1.addItem("ACCOUNTS OFFICE");
        cb2.addItem("SPORTS INSTRUCTOR");
        cb2.addItem("LECTURER");
        cb2.addItem("SENIOR PROFESSOR");
        cb2.addItem("ASSOCIATE PROFFESOR");
        cb2.addItem("ASSISTANT PROFESSOR");
        cb2.addItem("GUEST FACULTY");
        cb2.addItemListener(this);
        add(cb2);
        txt3 = new JTextField();
        txt3.setBounds(200, 330, 200, 30);
        txt3.setBorder(border);
        add(txt3);
        rd1 = new JRadioButton("MALE");
        rd1.setBounds(200, 380, 80, 30);
        rd1.setActionCommand("MALE");
        bg1 = new ButtonGroup();
        bg1.add(rd1);
        rd2 = new JRadioButton("FEMALE");
        rd2.setBounds(280, 380, 80, 30);
        rd2.setActionCommand("FEMALE");
        bg1.add(rd2);
        this.add(rd1);
        this.add(rd2);
        ta4 = new JTextArea();
        ta4.setBounds(200, 430, 200, 40);
        ta4.setBorder(border);
        add(ta4);
        txt5 = new JTextField();
        txt5.setBounds(200, 480, 200, 30);
        txt5.setBorder(border);
        add(txt5);
        txt6= new JTextField();
        txt6.setBounds(200, 530, 200, 30);
        txt6.setBorder(border);
        add(txt6);
        lb1=new JLabel("(yyyy-mm-dd)");
        lb1.setBounds(410,530,200,30);
        add(lb1);
        btn = new JButton("SUBMIT");
        btn.setBounds(300, 580, 100, 50);
        btn.setBorder(border);
        add(btn);
        btn.addActionListener(this);
        
        setLayout(null);
        setTitle("FACULTY REGISTRATION");
        setBounds(30, 30, 600, 720);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setVisible(true);
    }
/*
    public static void main(String[] arg) {
        String str = null, text1 = null, text2 = null;
        new Faculty_registration(text1, text2, str);
    }*/

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("SUBMIT".equals(e.getActionCommand())) {
            try {
                stmt = con.createStatement();
                String submit = "insert into faculty_registration(college_id,name,department,designation,email_id,gender,permanent_address,mobile_no,date_of_birth) values('" + txt1.getText() + "','" + txt2.getText() + "','" + cb1.getSelectedItem() + "','" + cb2.getSelectedItem() + "','" + txt3.getText() + "','" + bg1.getSelection().getActionCommand() + "','" + ta4.getText() + "','" + txt5.getText() + "','" + txt6.getText() + "')";
                System.out.println(submit);
                stmt.executeUpdate(submit);
                try {
                    String signup = "insert into facultylogin(username,e_mail,password) values('" + tex1 + "','" + tex2 + "','" + pass + "')";
                    System.out.println(signup);
                    stmt.executeUpdate(signup);
                    JOptionPane.showMessageDialog(rootPane, "REGISTERED SUCESSFULY !");
                    new project_login();
                    dispose();
                } catch (SQLException ex) {

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "ENTERED INFO IS WRONG");
                System.out.println(ex);
            }

        }
    }

}
