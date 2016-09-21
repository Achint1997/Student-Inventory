/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;

public class Subjects extends JFrame implements ActionListener {

    JLabel lb1, lb2, lb3;
    JLabel txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10;
    JButton btn;
    Statement stmt, stmt1;
    Connection con;
    ResultSet res1;
    public String str = null, subject = null, sem = null;

    public Subjects(String o) {
        con = JdbcConnection.getConnection();
        subject = o;
        System.out.println(subject);
        lb1 = new JLabel("SUBJECTS IN THIS SEMESTER");
        lb1.setBounds(120, 10, 550, 50);
        lb1.setForeground(Color.GREEN);
        lb1.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 40));
        add(lb1);

        lb1 = new JLabel("BRANCH  :");
        lb1.setBounds(80, 130, 80, 30);
        add(lb1);
        lb1 = new JLabel("SEMESTER  :");
        lb1.setBounds(400, 130, 150, 30);
        add(lb1);
        lb1 = new JLabel("LIST OF SUBJECTS");
        lb1.setBounds(80, 180, 250, 30);
        add(lb1);
        lb1 = new JLabel("1.");
        lb1.setBounds(80, 230, 150, 30);
        add(lb1);
        lb1 = new JLabel("2.");
        lb1.setBounds(80, 280, 150, 30);
        add(lb1);
        lb1 = new JLabel("3.");
        lb1.setBounds(80, 330, 150, 30);
        add(lb1);
        lb1 = new JLabel("4.");
        lb1.setBounds(80, 380, 150, 30);
        add(lb1);
        lb1 = new JLabel("5.");
        lb1.setBounds(80, 430, 150, 30);
        add(lb1);
        lb1 = new JLabel("6.");
        lb1.setBounds(80, 480, 150, 30);
        add(lb1);

        txt1 = new JLabel();
        txt1.setBounds(150, 130, 300, 30);
        add(txt1);
        txt2 = new JLabel();
        txt2.setBounds(490, 130, 300, 30);
        add(txt2);
        try {
            String str = "select * from student_registration where roll_no='" + subject + "'";
            System.out.println(str);
            stmt = con.createStatement();
            res1 = stmt.executeQuery(str);
            while (res1.next()) {
                txt1.setText(res1.getString("branch"));
                sem = res1.getString("semester");
            }
        } catch (Exception ex) {
        }
        System.out.println(sem);
        txt2.setText(sem);

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
        ArrayList<String> ary = new ArrayList<String>();
        try {
            String submit1 = "select * from student_subject where semester='" + sem + "'";
            System.out.println(submit1);
            stmt1 = con.createStatement();
            res1 = stmt1.executeQuery(submit1);

            while (res1.next()) {
                ary.add(res1.getString("subject"));
            }
        } catch (Exception ex) {
        }
        
        txt3.setText(ary.get(0));
        txt4.setText(ary.get(1));
        txt5.setText(ary.get(2));
        txt6.setText(ary.get(3));
        txt7.setText(ary.get(4));
        txt8.setText(ary.get(5));
        
        btn = new JButton("HOME");
        btn.setBounds(0, 0, 100, 20);
        add(btn);
        btn.addActionListener(this);

        setLayout(null);
        setBounds(30, 30, 750, 650);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent we) {
                return;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("HOME".equals(e.getActionCommand())) {
            new After_Login_window(subject);
            dispose();
        }
    }
/*
    public static void main(String[] arg) {
        String abc = null;
        new Subjects("1505210002");
    }*/
}
