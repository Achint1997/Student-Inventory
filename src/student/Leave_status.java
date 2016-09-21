/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Leave_status extends JFrame implements ActionListener,ItemListener{

    JLabel lbl, lb1, lb2, lb3;
    public String str = null, str1 = null, str2 = null;
    JComboBox cb1, cb2;
    JLabel txt1, txt2, txt3;
    JLabel ta1, ta2;
    JButton btn, btn1, btn2;
    Connection con;
    Statement stmt;
    ResultSet res;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    public String leave_status = null;

    public Leave_status(String o) {
        leave_status = o;
        con = JdbcConnection.getConnection();
        txt3 = new JLabel("SEE LEAVE STATUS");
        txt3.setBounds(30, 150, 200, 30);
        add(txt3);

        lbl = new JLabel("LEAVE STATUS");
        lbl.setBounds(100, 20, 500, 50);
        lbl.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 30));
        lbl.setForeground(Color.RED);
        add(lbl);
        cb1 = new JComboBox();
        cb1.setBounds(200, 150, 200, 30);
        cb1.setBorder(border);
        cb1.addItem("SEE");
        add(cb1);
        try {
            String string = "select * from student_registration where roll_no='" + leave_status + "'";
            System.out.println(string);
            stmt = con.createStatement();
            res = stmt.executeQuery(string);
            while (res.next()) {
                str = res.getString("name");
            }
        } catch (Exception ex) {
        }
        System.out.println(str);
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery("select message from leave_status where name='"+str+"'");
            while (res.next()) {
                cb1.addItem(res.getString("message"));
            }
        } catch (Exception e) {
        }
        btn1 = new JButton("HOME");
        btn1.setBounds(0, 0, 80, 30);
        add(btn1);
        btn1.addActionListener(this);

        setLayout(null);
        setTitle("LEAVE STATUS");
        setBounds(30, 30, 500, 400);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent we) {
                return;
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ("HOME".equals(ae.getActionCommand())) {
            new After_Login_window(leave_status);
            dispose();
    }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        cb1.removeItem(cb1.getSelectedItem());
    }
    /*
    public static void main(String []arg){
        String s=null;
        new Leave_status("1505210002");
    }*/
}
