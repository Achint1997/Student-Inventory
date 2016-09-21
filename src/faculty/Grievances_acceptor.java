/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculty;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import student.JdbcConnection;

public class Grievances_acceptor extends JFrame implements ActionListener {

    JLabel lbl, lb1, lb2, lb3;
    public String str = null, str2 = null, griev_id = null;
    JComboBox cb1, cb2;
    JLabel txt1, txt2, txt3;
    JLabel ta1, ta2;
    JButton btn, btn1, btn2;
    Connection con;
    Statement stmt;
    ResultSet res;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    public String griev_acc = null;

    public Grievances_acceptor(String o, String p) {
        griev_id = o;
        griev_acc = p;
        con = JdbcConnection.getConnection();

        lbl = new JLabel("QUERY");
        lbl.setBounds(250, 10, 500, 50);
        lbl.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 30));
        lbl.setForeground(Color.MAGENTA);
        add(lbl);

        lb1 = new JLabel("SENDER");
        lb1.setBounds(30, 90, 100, 30);
        add(lb1);
        lb1 = new JLabel("REASON FOR ");
        lb1.setBounds(30, 150, 100, 30);
        add(lb1);
        lb1 = new JLabel("QUERY");
        lb1.setBounds(30, 170, 100, 30);
        add(lb1);

        lb2 = new JLabel();
        lb2.setBounds(180, 90, 200, 30);
        add(lb2);
        ta1 = new JLabel();
        ta1.setBounds(180, 150, 300, 200);
        add(ta1);
        ta1.setBorder(border);

        try {
            stmt = con.createStatement();
            res = stmt.executeQuery("select * from student_leave where id='" + griev_id + "'");
            while (res.next()) {
                str2 = res.getString("sender");
                txt2.setText(res.getString("date_of_departure"));
                txt3.setText(res.getString("date_of_arrival"));
                ta1.setText(res.getString("cause"));
            }
        } catch (Exception e) {
        }
        lb2.setText(str2);

        btn = new JButton("APPROVE");
        btn.setBounds(180, 400, 120, 50);
        add(btn);
        btn.addActionListener(this);

        btn2 = new JButton("DISAPPROVE");
        btn2.setBounds(350, 400, 120, 50);
        add(btn2);
        btn2.addActionListener(this);

        btn1 = new JButton("BACK");
        btn1.setBounds(0, 0, 80, 30);
        add(btn1);
        btn1.addActionListener(this);

        setLayout(null);
        setTitle("GRIEVANCES ACCEPTOR");
        setBounds(30, 30, 700, 600);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent we) {
                return;
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if ("BACK".equals(ae.getActionCommand())) {
            new Faculty_after_login(griev_acc);
            dispose();
        } else if ("APPROVE".equals(ae.getActionCommand())) {
            try {
                stmt = con.createStatement();
                String string = "insert into grievances_status(name,message) values('" + str2 + "','APPROVED')";
                System.out.println(string);
                stmt.executeUpdate(string);
                String str = "delete  from student_grievances where id='" + griev_id + "'";
                System.out.println(str);
                stmt.executeUpdate(str);

            } catch (Exception ex) {
            }
        } else if ("DISAPPROVE".equals(ae.getActionCommand())) {
            try {
                stmt = con.createStatement();
                String string = "insert into grievances_status(name,message) values('" + str2 + "','DISAPPROVED')";
                System.out.println(string);
                stmt.executeUpdate(string);
                String str = "delete * from student_grievanves where id='" + griev_id + "'";
                System.out.println(str);
                stmt.executeUpdate(str);
                
            } catch (SQLException ex) {

            }
        }
    }

    public static void main(String[] arg) {
        String a = null, b = null;
        new Grievances_acceptor(a, b);
    }
}
