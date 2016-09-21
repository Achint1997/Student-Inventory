/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author HP
 */
public class Lectures extends JFrame implements ActionListener,ItemListener {

    JButton button;
    JLabel label, lb1, lb2;
    JTextField jtf;
    JComboBox cb1;
    Connection con;
    public String sem=null,lectures = null;
    private final JButton btn1;
    Statement stmt;
    ResultSet res,res1;

    public Lectures(String o) {
        lectures=o;
        con=JdbcConnection.getConnection();
        label = new JLabel("LECTURES");
        label.setBounds(180, 10, 800, 50);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 40));
        add(label);
        label = new JLabel("SELECT TIME TABLE OF YOUR SEMESTER");
        label.setBounds(50, 130, 300, 30);
        add(label);
        button = new JButton("SHOW");
        button.setBounds(430, 130, 100, 30);
        add(button);
        button.addActionListener(this);
        cb1 = new JComboBox();
        cb1.setBounds(300, 130, 100, 30);
        cb1.addItem("SELECT");
       
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery("select ID from mytimetable ");
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

        btn1 = new JButton("BACK");
        btn1.setBounds(0, 0, 100, 20);
        add(btn1);
        btn1.addActionListener(this);

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
                res = stmt.executeQuery("select * from mytimetable where ID='" + cb1.getSelectedItem() + "'");
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
        } else if ("BACK".equals(e.getActionCommand())) {
            new After_Login_window(lectures);
            dispose();
        }
    }
/*
    public static void main(String[] arg) {
        String s = null;
        new Lectures("1505210002");
    }
*/
    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
