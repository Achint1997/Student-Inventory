/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Attendance extends JFrame implements ActionListener {

    JLabel lbl, lb1, lb2, lb3;
    JComboBox cb1, cb2, cb3;
    JTextField txt1, txt2, txt3;
    JTextArea ta1, ta2;
    JButton btn, btn1;
    Connection con;
    Statement stmt;
    ResultSet res1, res;
    public String sem = null, attend = null, roll = null;
    int i = 1;

    public Attendance(String o) {
        attend = o;
        System.out.println(attend);
        con = JdbcConnection.getConnection();

        lbl = new JLabel("ATTENDANCE");
        lbl.setBounds(280, 10, 400, 50);
        lbl.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 50));
        lbl.setForeground(Color.RED);
        add(lbl);
        lb1 = new JLabel("BRANCH");
        lb1.setBounds(30, 110, 200, 30);
        add(lb1);
        lb1 = new JLabel();
        lb1.setBounds(200, 110, 200, 30);
        add(lb1);
        try {
            String submit1 = "select * from student_registration where roll_no='" + attend + "'";
            System.out.println(submit1);
            stmt = con.createStatement();
            res1 = stmt.executeQuery(submit1);
            while (res1.next()) {
                lb1.setText(res1.getString("branch"));
                sem = res1.getString("semester");
            }
        } catch (Exception ex) {
        }

        lb1 = new JLabel("UPDATE ATTENDANCE");
        lb1.setBounds(30, 200, 200, 30);
        add(lb1);
        lb1 = new JLabel("CURRENT ATTENDANCE");
        lb1.setBounds(30, 260, 200, 30);
        add(lb1);
        lb1 = new JLabel("ENTER PRESENT OR ABSENT");
        lb1.setBounds(200, 170, 300, 30);
        add(lb1);

        txt1 = new JTextField("P/A");
        txt1.setBounds(220, 200, 100, 30);
        add(txt1);
        btn = new JButton("UPDATE");
        btn.setBounds(400, 200, 100, 30);
        add(btn);
        btn.addActionListener(this);

        lb3 = new JLabel();
        lb3.setBounds(220, 260, 200, 30);
        add(lb3);

        btn1 = new JButton("HOME");
        btn1.setBounds(0, 0, 80, 30);
        add(btn1);
        btn1.addActionListener(this);

        setLayout(null);
        setBounds(30, 30, 900, 500);
        setTitle("ATTENDANCE");
        getContentPane().setBackground(Color.decode("#bdb76b"));
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent we) {
                return;
            }
        });
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if ("HOME".equals(ae.getActionCommand())) {
            new After_Login_window(attend);
            dispose();
        } else if ("UPDATE".equals(ae.getActionCommand())) {
            double p = 0, a = 0, t = 0, result = 0;
            try {
                String str = "insert into attendance(Semester,roll_no,Status) values('" + sem + "','" + attend + "','" + txt1.getText() + "')";
                System.out.println(str);
                stmt.executeUpdate(str);
                String att = "select * from attendance where roll_no=attend";
                res = stmt.executeQuery(att);
            } catch (SQLException ex) {
            }
            JOptionPane.showMessageDialog(null, "ATTENDANCE SUBMITTED");
            ArrayList<String> ary = new ArrayList<String>();
            try {
                String submit1 = "select * from attendance where roll_no='" + attend + "'";
                System.out.println(submit1);
                stmt = con.createStatement();
                res1 = stmt.executeQuery(submit1);
                while (res1.next()) {
                    ary.add(res1.getString("Status"));
                    
                }
                int i = 0;
                while (ary.size() > i) {
                    System.out.println("1223");
                    t++;
                    if (ary.get(i).equals("P")) {
                        p++;
                    } else if(ary.get(i).equals("A")) {
                        a++;
                    }
                    i++;
                }
                result = (p/ t) * 100;
                System.out.println(result);
                String f=new DecimalFormat("#0.00").format(result);
                String s = "" + f + " %";
                lb3.setText(s);
            } catch (Exception ex) {
            }
        }

    }
    /*
     public void itemStateChanged(ItemEvent ie) {

     if (i == 1) {
     cb2.removeAllItems();
     String str = "select subject from student_subject where semester='" + cb1.getSelectedItem() + "' ";
     try {
     stmt = con.createStatement();
     set = stmt.executeQuery(str);
     System.out.println(str);
     cb2.addItem("Select Subject");
     while (set.next()) {
     cb2.addItem(set.getString(1));
     }
     } catch (Exception ex) {
     }
     }
     i++;
     if (i == 2) {
     i = 1;
     }
     }

    public static void main(String[] arg) {
        String res = null;
        new Attendance("1505210002");
    }*/

}
