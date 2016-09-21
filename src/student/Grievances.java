/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Grievances extends JFrame implements ActionListener {

    JLabel lbl, lb1, lb2, lb3;
    JComboBox cb1, cb2;
    JTextField txt1, txt2, txt3;
    JTextArea ta1, ta2;
    JButton btn, btn1;
    Connection con;
    Statement stmt;
    ResultSet res;
    public String str = null;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    public  String grieveances=null;

    public Grievances(String o) {
        grieveances=o;
        lbl = new JLabel("REPORT ANY PROBLEM");
        lbl.setBounds(150, 10, 400, 50);
        lbl.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 30));
        lbl.setForeground(Color.BLUE);
        add(lbl);
        
        lb1=new JLabel("FROM");
        lb1.setBounds(30,90,100,30);
        add(lb1);
        lb1 = new JLabel("TO");
        lb1.setBounds(30, 150, 100, 30);
        add(lb1);
        lb3 = new JLabel("REASON FOR ");
        lb3.setBounds(30, 210, 100, 30);
        add(lb3);
        lb3 = new JLabel("DIFFICULTY");
        lb3.setBounds(30, 230, 100, 30);
        add(lb3);
        
        txt1=new JTextField();
        txt1.setBounds(180,90,200,30);
        add(txt1);
        txt1.setBorder(border);

        cb1 = new JComboBox();
        cb1.setBounds(180, 150, 200, 30);
        cb1.addItem("DEAN OF STUDENT WELFARE");
        cb1.addItem("DEAN OF ACADEMICS");
        cb1.addItem("SPORTS CONSTRUCTOR");
        cb1.setBorder(border);
        add(cb1);

        ta1 = new JTextArea();
        ta1.setBounds(180, 210, 300, 200);
        ta1.setBorder(border);
        add(ta1);

        btn = new JButton("SEND");
        btn.setBounds(180, 420, 100, 50);
        add(btn);
        btn.addActionListener(this);

        btn1 = new JButton("BACK");
        btn1.setBounds(0, 0, 80, 30);
        add(btn1);
        btn1.addActionListener(this);

        setLayout(null);
        setTitle("GRIEVANCES");
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
            new After_Login_window(grieveances);
            dispose();
        } else if ("SEND".equals(ae.getActionCommand())) {
            try {
                con = JdbcConnection.getConnection();
                stmt = con.createStatement();
                String str = "insert * into student_grievances(sender,send_to,query) values('" + txt1.getText() + "','" + cb1.getSelectedItem() + "','" + ta1.getText() + "') ";
                System.out.println(str);
                stmt.executeUpdate(str);
            } catch (Exception e) {

            }
        }
    }
/*
    public static void main(String[] arg) {
        String s=null;
        new Grievances("1505210002");

    }
*/
}
