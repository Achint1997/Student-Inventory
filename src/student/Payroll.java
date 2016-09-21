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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author HP
 */
public class Payroll extends JFrame implements ActionListener, ItemListener {

    JLabel lbl, lb1, lb2, lb3, lb4, lb5, lb6, lb7;
    public String str = null, payroll = null, item_str = null;
    JComboBox cb1, cb2;
    JTextField txt1, txt2, txt3;
    JTextArea ta1, ta2;
    JButton btn, btn1;
    JPasswordField pass;
    Connection con;
    Statement stmt, stmt1;
    ResultSet res;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    public Payroll(String o) {
        super("FEE PAYING PORTAL");
        payroll=o;
        con = JdbcConnection.getConnection();
        lbl = new JLabel("APPLY FOR LEAVE");
        lbl.setBounds(150, 10, 300, 50);
        lbl.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 30));
        lbl.setForeground(Color.BLUE);
        add(lbl);

        lb1 = new JLabel("ROLL NO.");
        lb1.setBounds(30, 90, 100, 30);
        add(lb1);
        lb1 = new JLabel("BRANCH");
        lb1.setBounds(30, 150, 100, 30);
        add(lb1);
        lb1 = new JLabel("SEMESTER");
        lb1.setBounds(30, 210, 150, 30);
        add(lb1);
        lb1 = new JLabel("PAY BY DEBIT / CREDIT CARD");
        lb1.setBounds(150, 260, 290, 30);
        add(lb1);
        lb1 = new JLabel("CARD NO.");
        lb1.setBounds(30, 320, 100, 30);
        add(lb1);
        lb1 = new JLabel("EXPIRY/VALID THRU");
        lb1.setBounds(30, 360, 300, 30);
        add(lb1);
        lb1 = new JLabel("NAME ON THE CARD");
        lb1.setBounds(30, 400, 200, 30);
        add(lb1);

        pass = new JPasswordField();
        pass.setBounds(210, 320, 150, 30);
        add(pass);
        txt2=new JTextField();
        txt2.setBounds(210,360,150,30);
        add(txt2); 
        txt3=new JTextField();
        txt3.setBounds(210,400,150,30);
        add(txt3);

        lb2 = new JLabel();
        lb2.setBounds(210, 90, 200, 30);
        add(lb2);
        lb3 = new JLabel();
        lb3.setBounds(210, 150, 200, 30);
        add(lb3);
        lb4 = new JLabel();
        lb4.setBounds(210, 210, 80, 30);
        add(lb4);
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery("select * from student_registration where roll_no='"+payroll+"'");
            while (res.next()) {
                lb2.setText(res.getString("roll_no"));
                lb3.setText(res.getString("branch"));
                lb4.setText(res.getString("semester"));
            }
        } catch (Exception e) {
        }
        
        btn = new JButton("PAY");
        btn.setBounds(180, 480, 100, 50);
        add(btn);
        btn.addActionListener(this);

        btn1 = new JButton("HOME");
        btn1.setBounds(0, 0, 80, 30);
        add(btn1);
        
        btn1.addActionListener(this);
        setLayout(null);
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
        if ("HOME".equals(ae.getActionCommand())) {
            new After_Login_window(payroll);
            dispose();
        } else if ("PAY".equals(ae.getActionCommand())) {
            String string =new String(pass.getPassword());
            try {
                stmt1 = con.createStatement();
                String str = "insert into fee_pay(Card_no,cvv,name) values('" +string + "','" +txt2.getText() + "','" + txt3.getText() + "')";
                System.out.println(str);
                stmt1.executeUpdate(str);
                JOptionPane.showMessageDialog(this,"FEES PAID");
                new After_Login_window(payroll);
                dispose();
            } catch (Exception ex) {

            }

        }
    }
/*
    public static void main(String[] arg) {
        String s = null;
        new Payroll(s);
    }*/
}
