/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;

public class Student_registration extends JFrame implements ActionListener, ItemListener {

    JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt17, txt18, txt19, txt20;
    JTextArea ta6, ta7;
    JComboBox cb, cb1;
    JRadioButton rd1, rd2, rd3, rd4, rd5, rd6;
    JButton btn;
    ButtonGroup bg1, bg2, bg3;
    Connection con;
    Statement stmt;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    public String tex1=null,tex2=null,pass=null;

    public Student_registration(String text1, String text2, String str) {
        tex1 = text1;
        tex2 = text2;
        pass = str;

        lb1 = new JLabel("ROLL NO.");
        lb1.setBounds(30, 130, 150, 30);
        add(lb1);
        lb2 = new JLabel("BRANCH");
        lb2.setBounds(30, 180, 150, 30);
        add(lb2);
        lb3 = new JLabel("FATHER'S NAME");
        lb3.setBounds(30, 230, 150, 30);
        add(lb3);
        lb4 = new JLabel("STUDENT E-MAIL ID");
        lb4.setBounds(30, 280, 150, 30);
        add(lb4);
        lb5 = new JLabel("GENDER");
        lb5.setBounds(30, 330, 150, 30);
        add(lb5);
        lb6 = new JLabel("PERMANENT ADDRESS");
        lb6.setBounds(30, 380, 150, 30);
        add(lb6);
        lb7 = new JLabel("GUARDIAN ADDRESS");
        lb7.setBounds(30, 430, 150, 30);
        add(lb7);
        lb8 = new JLabel("CATEGORY");
        lb8.setBounds(30, 480, 150, 30);
        add(lb8);
        lb9 = new JLabel("DISABILITY");
        lb9.setBounds(30, 530, 150, 30);
        add(lb9);
        lb10 = new JLabel("MINORITY");
        lb10.setBounds(30, 580, 150, 30);
        add(lb10);

        txt1 = new JTextField();
        txt1.setBounds(200, 130, 150, 30);
        txt1.setBorder(border);
        add(txt1);
        cb1 = new JComboBox();
        cb1.setBounds(200, 180, 150, 30);
        cb1.setBorder(border);
        cb1.addItem("SELECT BRANCH");
        cb1.addItem("CHEMICAL ENGINEERING");
        cb1.addItem("CIVIL ENGINEERING");
        cb1.addItem("COMPUTER SCIENCE ");
        cb1.addItem("ELECTRICAL ENGINEERING");
        cb1.addItem("ELECTRONICS ENGINEERING");
        cb1.addItem("MECHANICAL ENGINEERING");
        cb1.addItemListener(this);
        add(cb1);
        txt3 = new JTextField();
        txt3.setBounds(200, 230, 150, 30);
        txt3.setBorder(border);
        add(txt3);
        txt4 = new JTextField();
        txt4.setBounds(200, 280, 150, 30);
        txt4.setBorder(border);
        add(txt4);

        rd1 = new JRadioButton("MALE");
        rd1.setBounds(200, 330, 80, 30);
        rd1.setActionCommand("MALE");
        bg1 = new ButtonGroup();
        bg1.add(rd1);
        rd2 = new JRadioButton("FEMALE");
        rd2.setBounds(280, 330, 80, 30);
        rd2.setActionCommand("FEMALE");
        bg1.add(rd2);
        this.add(rd1);
        this.add(rd2);

        ta6 = new JTextArea();
        ta6.setBounds(200, 380, 200, 40);
        add(ta6);
        ta6.setBorder(border);

        ta7 = new JTextArea();
        ta7.setBounds(200, 430, 200, 40);
        add(ta7);
        ta7.setBorder(border);

        cb = new JComboBox();
        cb.setBounds(200, 480, 150, 30);
        cb.addItem("SELECT");
        cb.addItem("GENERAL");
        cb.addItem("OBC");
        cb.addItem("SC");
        cb.addItem("ST");
        add(cb);

        rd3 = new JRadioButton("YES");
        rd3.setBounds(200, 530, 50, 30);
        rd3.setActionCommand("YES");
        bg2 = new ButtonGroup();
        bg2.add(rd3);
        rd4 = new JRadioButton("NO");
        rd4.setBounds(250, 530, 50, 30);
        rd4.setActionCommand("NO");
        bg2.add(rd4);
        this.add(rd3);
        this.add(rd4);

        rd5 = new JRadioButton("YES");
        rd5.setBounds(200, 580, 50, 30);
        rd5.setActionCommand("YES");
        bg3 = new ButtonGroup();
        bg3.add(rd5);
        rd6 = new JRadioButton("No");
        rd6.setBounds(250, 580, 50, 30);
        rd6.setActionCommand("NO");
        bg3.add(rd6);
        this.add(rd5);
        this.add(rd6);

        lb1 = new JLabel("NAME");
        lb1.setBounds(530, 130, 150, 30);
        add(lb1);
        lb2 = new JLabel("SEMESTER");
        lb2.setBounds(530, 180, 150, 30);
        add(lb2);
        lb3 = new JLabel("MOTHER'S NAME");
        lb3.setBounds(530, 230, 150, 30);
        add(lb3);
        lb4 = new JLabel("STUDENT MOBILE");
        lb4.setBounds(530, 280, 150, 30);
        add(lb4);
        lb5 = new JLabel("FATHER MOBILE");
        lb5.setBounds(530, 330, 150, 30);
        add(lb5);
        lb6 = new JLabel("DATE OF BIRTH");
        lb6.setBounds(530, 380, 150, 30);
        add(lb6);
        lb7 = new JLabel("TYPE OF DISABILITY");
        lb7.setBounds(530, 530, 150, 30);
        add(lb7);
        lb8 = new JLabel("MINORITY CATEGORY");
        lb8.setBounds(530, 580, 150, 30);
        add(lb8);

        txt11 = new JTextField();
        txt11.setBounds(700, 130, 150, 30);
        txt11.setBorder(border);
        add(txt11);
        txt12 = new JTextField();
        txt12.setBounds(700, 180, 150, 30);
        txt12.setBorder(border);
        add(txt12);
        txt13 = new JTextField();
        txt13.setBounds(700, 230, 150, 30);
        txt13.setBorder(border);
        add(txt13);
        txt14 = new JTextField();
        txt14.setBounds(700, 280, 150, 30);
        txt14.setBorder(border);
        add(txt14);
        txt15 = new JTextField();
        txt15.setBounds(700, 330, 150, 30);
        txt15.setBorder(border);
        add(txt15);
        txt16 = new JTextField();
        txt16.setBounds(700, 380, 150, 30);
        txt16.setBorder(border);
        add(txt16);
        lb1 = new JLabel("(yyyy-mm-dd)");
        lb1.setBounds(860, 380, 150, 30);
        add(lb1);
        txt17 = new JTextField();
        txt17.setBounds(700, 530, 150, 30);
        txt17.setBorder(border);
        add(txt17);
        txt18 = new JTextField();
        txt18.setBounds(700, 580, 150, 30);
        txt18.setBorder(border);
        add(txt18);

        btn = new JButton("SUBMIT");
        btn.setBounds(500, 650, 100, 50);
        btn.setBorder(border);
        add(btn);
        btn.addActionListener(this);

        setLayout(null);
        setTitle("STUDENT REGISTRATION");
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setBounds(30, 30, 1400, 720);
        setVisible(true);

    }
/*
    public static void main(String[] arg) {
        String str = null, text1 = null, text2 = null;
        new Student_registration(text1, text2, str);

    }*/

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("SUBMIT".equals(e.getActionCommand())) {
                    con = JdbcConnection.getConnection();
                    try {
                        stmt = con.createStatement();
                        String submit = "insert into student_registration(roll_no,branch,father_name,student_email_id,gender,permanent_address,guardian_address,category,disabilty,minority,name,semester,mother_name,student_mobile_no,father_mobile_no,date_of_birth,type_of_disabilty,minority_category) values('" + txt1.getText() + "','" + cb1.getSelectedItem() + "','" + txt3.getText() + "','" + txt4.getText() + "','" + bg1.getSelection().getActionCommand() + "', '" + ta6.getText() + "','" + ta7.getText() + "','" + cb.getSelectedItem() + "','" + bg2.getSelection().getActionCommand() + "','" + bg3.getSelection().getActionCommand() + "', '" + txt11.getText() + "','" + txt12.getText() + "','" + txt13.getText() + "','" + txt14.getText() + "','" + txt15.getText() + "','"+txt16.getText()+"','" + txt17.getText() + "','" + txt18.getText() + "')";
                        System.out.println(submit);
                        stmt.executeUpdate(submit);
                        try {
                            String signup = "insert into studentlogin(username,e_mail,password) values('" + tex1 + "','" + tex2 + "','" + pass + "')";
                            System.out.println(signup);
                            stmt.executeUpdate(signup);
                            new project_login();
                            dispose();
                        } catch (SQLException ex) {

                        }
                    } catch (Exception ex) {
                       JOptionPane.showMessageDialog(this,"ENTERD INFO IS WRONG");
                        System.out.println(ex);
                    }

                }
            }
    

}
