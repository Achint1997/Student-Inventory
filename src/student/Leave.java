/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Leave extends JFrame implements ActionListener, ItemListener {

    JLabel lbl, lb1, lb2, lb3;
    public String str = null, leave = null, item_str = null;
    JComboBox cb1, cb2;
    JTextField txt1, txt2, txt3;
    JTextArea ta1, ta2;
    JButton btn, btn1;
    Connection con;
    Statement stmt,stmt1;
    ResultSet res;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    public Leave(String o) {
        leave = o;
        con = JdbcConnection.getConnection();
        lbl = new JLabel("APPLY FOR LEAVE");
        lbl.setBounds(150, 10, 300, 50);
        lbl.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 30));
        lbl.setForeground(Color.BLUE);
        add(lbl);

        lb1 = new JLabel("FROM");
        lb1.setBounds(30, 90, 100, 30);
        add(lb1);
        lb1 = new JLabel("TO");
        lb1.setBounds(30, 150, 100, 30);
        add(lb1);
        lb2 = new JLabel("DATES OF ABSENCE");
        lb2.setBounds(30, 210, 150, 30);
        add(lb2);
        lb3 = new JLabel("FROM");
        lb3.setBounds(200, 210, 100, 30);
        add(lb3);
        lb3 = new JLabel("TO");
        lb3.setBounds(350, 210, 100, 30);
        add(lb3);
        lb3 = new JLabel("(yyyy-mm-dd)");
        lb3.setBounds(490, 210, 100, 30);
        add(lb3);
        lb3 = new JLabel("REASON FOR ");
        lb3.setBounds(30, 260, 100, 30);
        add(lb3);
        lb3 = new JLabel("LEAVE");
        lb3.setBounds(30, 280, 100, 30);
        add(lb3);

        txt1 = new JTextField();
        txt1.setBounds(180, 90, 200, 30);
        add(txt1);

        cb1 = new JComboBox();
        cb1.setBounds(180, 150, 200, 30);
        cb1.setBorder(border);
        cb1.addItemListener(this);
        cb1.addItem("SEND TO");
        con = JdbcConnection.getConnection();
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery("select name from faculty_registration");
            while (res.next()) {
                cb1.addItem(res.getString(1));
            }
        } catch (Exception e) {
        }
        add(cb1);

        txt2 = new JTextField();
        txt2.setBounds(250, 210, 80, 30);
        add(txt2);
        txt2.setBorder(border);
        txt3 = new JTextField();
        txt3.setBounds(400, 210, 80, 30);
        add(txt3);
        txt3.setBorder(border);

        ta1 = new JTextArea();
        ta1.setBounds(180, 260, 300, 200);
        add(ta1);
        ta1.setBorder(border);

        btn = new JButton("SEND");
        btn.setBounds(180, 480, 100, 50);
        add(btn);
        btn.addActionListener(this);

        btn1 = new JButton("BACK");
        btn1.setBounds(0, 0, 80, 30);
        add(btn1);
        btn1.addActionListener(this);
        setLayout(null);
        setTitle("LEAVE APPLICATION");
        setBounds(30, 30, 700, 600);
        setVisible(true);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent we) {
                return;
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }

    public void actionPerformed(ActionEvent ae) {
        if ("BACK".equals(ae.getActionCommand())) {
            new After_Login_window(leave);
            dispose();
        } else if ("SEND".equals(ae.getActionCommand())) {

            try {
                stmt1 = con.createStatement();
                String str = "insert into student_leave(sender,send_to,date_of_departure,date_of_arrival,cause) values('" + txt1.getText() + "','" + cb1.getSelectedItem() + "','" + txt2.getText() + "','" + txt3.getText() + "','" + ta1.getText() + "') ";
                System.out.println(str);
                stmt1.executeUpdate(str);
                new After_Login_window(leave);
                dispose();
            } catch (Exception ex) {

            }

        }
    }
/*
    public static void main(String[] arg) {
        String s = null;
        new Leave("1505210002");
    }
*/
}
