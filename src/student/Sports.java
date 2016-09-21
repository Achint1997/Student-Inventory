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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class Sports extends JFrame implements ActionListener {

    JButton btn1;
    JLabel pic, lb1;
    public String sports = null;

    public Sports(String o) {
        super("SPORTS IN I. E. T. LUCKNOW");
        sports = o;
        lb1 = new JLabel("WELCOME TO COLLEGE SPORTS PAGE");
        lb1.setBounds(70, 25, 700, 50);
        lb1.setFont(new Font("GREYSCALE", Font.BOLD, 30));
        add(lb1);

        lb1 = new JLabel(".");
        lb1.setBounds(20, 100, 30, 50);
        lb1.setFont(new Font("GREYSCALE", Font.BOLD, 40));
        add(lb1);
        lb1 = new JLabel("I.E.T. COLLEGE WAS SETUP IN 1984 WITH IIM LUCKNOW AND SGPGI.");
        lb1.setBounds(40, 110, 700, 50);
        lb1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        add(lb1);
        lb1 = new JLabel(".");
        lb1.setBounds(20, 160, 30, 50);
        lb1.setFont(new Font("GREYSCALE", Font.BOLD, 40));
        add(lb1);
        lb1 = new JLabel("RANKED 2nd IN UTTAR PRADESH ENGINEERING COLLEGES.");
        lb1.setBounds(40, 170, 700, 50);
        lb1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        add(lb1);
        lb1 = new JLabel(".");
        lb1.setBounds(20, 220, 30, 50);
        lb1.setFont(new Font("GREYSCALE", Font.BOLD, 40));
        add(lb1);
        lb1 = new JLabel("AN AUTONOMOUS GOVERNMENT COLLEGE.");
        lb1.setBounds(40, 230, 700, 50);
        lb1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        add(lb1);
        lb1 = new JLabel(".");
        lb1.setBounds(20, 280, 30, 50);
        lb1.setFont(new Font("GREYSCALE", Font.BOLD, 40));
        add(lb1);
        lb1 = new JLabel("ORGANISES SHAURYAUTSAVA EACH YEAR IN THE MONTH OF FEBRUARY.");
        lb1.setBounds(40, 290, 720, 50);
        lb1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        add(lb1);
        lb1 = new JLabel(".");
        lb1.setBounds(20, 340, 30, 50);
        lb1.setFont(new Font("GREYSCALE", Font.BOLD, 40));
        add(lb1);
        lb1 = new JLabel("WINNER TAKES A GRAET AMOUNT OF CASH & MEDALS.");
        lb1.setBounds(40, 350, 700, 50);
        lb1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        add(lb1);

        btn1 = new JButton("HOME");
        btn1.setBounds(0, 0, 100, 20);
        add(btn1);
        btn1.addActionListener(this);

        setLayout(null);
        setBounds(0, 0, 768, 600);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("HOME".equals(e.getActionCommand())) {
            new After_Login_window(sports);
            dispose();
        }
    }
/*
    public static void main(String[] arg) {
        String s = null;
        new Sports(s);
    }*/
}
