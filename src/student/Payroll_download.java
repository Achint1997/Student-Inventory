/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class Payroll_download extends JFrame implements ActionListener,ItemListener {

    JButton button,btn2;
    JLabel label, lb1, lb2;
    JTextField jtf;
    JComboBox cb1;
    Connection con;
    public String payroll_d = null;
    private final JButton btn1;
    Statement stmt;
    ResultSet res;

    public Payroll_download(String o) {
        super("PAYROLL DOWNLOAD");
        payroll_d = o;
        con = JdbcConnection.getConnection();

        label = new JLabel("PAYROLL");
        label.setBounds(200, 10, 800, 50);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 40));
        add(label);
        label = new JLabel("SELECT");
        label.setBounds(150, 130, 150, 30);
        add(label);
        button = new JButton("SHOW");
        button.setBounds(340, 130, 100, 30);
        add(button);
        button.addActionListener(this);
        cb1 = new JComboBox();
        cb1.setBounds(220, 130, 100, 30);
        cb1.addItem("SELECT");
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery("select ID from payroll ");
            while (res.next()) {
                cb1.addItem(res.getString("ID"));
            }
        } catch (SQLException ex) {

        }
        add(cb1);
        cb1.addItemListener(this);

        label = new JLabel();
        label.setBounds(100, 250, 500, 400);
        add(label);
        lb1 = new JLabel("Description");
        lb1.setBounds(150, 200, 80, 30);
        add(lb1);
        lb2 = new JLabel();
        lb2.setBounds(250, 200, 600, 30);
        add(lb2);

        btn1 = new JButton("HOME");
        btn1.setBounds(0, 0, 100, 20);
        add(btn1);
        btn1.addActionListener(this);
        
        btn2= new JButton("PAY FEES");
        btn2.setBounds(584, 0, 100, 20);
        add(btn2);
        btn2.addActionListener(this);

        setLayout(null);
        setBounds(30, 30, 700, 700);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("SHOW".equals(e.getActionCommand())) {
            try {
                con = JdbcConnection.getConnection();
                stmt = con.createStatement();
                res = stmt.executeQuery("select * from payroll where ID='" + cb1.getSelectedItem() + "'");
                if (res.next()) {
                    lb2.setText(res.getString("Description"));
                    byte[] img = res.getBytes("image");
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    label.setIcon(newImage);
                }
            } catch (Exception ex) {
            }
        } else if ("HOME".equals(e.getActionCommand())) {
            new After_Login_window(payroll_d);
            dispose();
        }
        else if ("PAY FEES".equals(e.getActionCommand())) {
            new Payroll(payroll_d);
            dispose();
        }
    }
/*
    public static void main(String[] arg) {
        String s = null;
        new Payroll_download(s);
    }
*/
    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}

