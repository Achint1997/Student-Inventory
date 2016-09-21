/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faculty;

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
import student.JdbcConnection;

public class Grievances_chooser extends JFrame implements ActionListener, ItemListener {

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
    public String griev_chooser = null;

    public Grievances_chooser(String o) {
        griev_chooser=o;
        con = JdbcConnection.getConnection();
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery("select name from faculty_registration where college_id='"+griev_chooser+"' ");
            while (res.next()) {
                str=res.getString("name");
            }
        } catch (Exception e) {
        }
        txt3 = new JLabel("SELECT QUERY");
        txt3.setBounds(30, 150, 100, 30);
        add(txt3);

        lbl = new JLabel("QUERY CHOOSER");
        lbl.setBounds(120, 10, 500, 50);
        lbl.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 30));
        lbl.setForeground(Color.RED);
        add(lbl);
        cb1 = new JComboBox();
        cb1.setBounds(180, 150, 200, 30);
        cb1.setBorder(border);
        cb1.addItemListener(this);
        cb1.addItem("SELECT");
        
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery("select id from student_grievances where send_to='"+str+"'");
            while (res.next()) {
                cb1.addItem(res.getString(1));
            }
        } catch (Exception e) {
        }
        add(cb1);
        btn= new JButton("SELECT");
        btn.setBounds(180,200,100,30);
        btn.setBorder(border);
        add(btn);
        btn.addActionListener(this);
        
        btn1 = new JButton("BACK");
        btn1.setBounds(0, 0, 80, 30);
        add(btn1);
        btn1.addActionListener(this);
        
        setLayout(null);
        setTitle("GRIEVANCES CHOOSER");
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
    public void actionPerformed(ActionEvent e) {
        if("SELECT".equals(e.getActionCommand())){
            new Grievances_acceptor((String)cb1.getSelectedItem(),griev_chooser);
            dispose();
        }
        else if("BACK".equals(e.getActionCommand())){
            new Faculty_after_login(griev_chooser);
            dispose();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
    
    public static void main(String[] arg) {
        String s=null;
        new Grievances_chooser(s);
    }
}
