package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class main extends JFrame implements ActionListener {

    JMenu m1;
    JMenuBar mbar;
    JMenuItem m_item1, m_item2;
    JLabel pic,lb1;
    Timer tm;
    int x = 0;
    //Images Path In Array
    String[] list = {
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\11.jpg",
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\12,jpg",
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\6.jpg",
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\8.jpg",
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\5.jpg",};

    public main() {
        lb1=new JLabel("WELCOME TO COLLEGE PORTAL");
        lb1.setBounds(30,25,700,50);
        lb1.setFont(new Font("GREYSCALE",Font.BOLD,40));
        add(lb1);
        
        lb1=new JLabel(".");
        lb1.setBounds(20,100,30,50);
        lb1.setFont(new Font("GREYSCALE",Font.BOLD,40));
        add(lb1);
        lb1=new JLabel("I.E.T. COLLEGE WAS SETUP IN 1984 WITH IIM LUCKNOW AND SGPGI.");
        lb1.setBounds(40,110,700,50);
        lb1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        add(lb1);
        lb1=new JLabel(".");
        lb1.setBounds(20,160,30,50);
        lb1.setFont(new Font("GREYSCALE",Font.BOLD,40));
        add(lb1);
        lb1=new JLabel("RANKED 2nd IN UTTAR PRADESH ENGINEERING COLLEGES.");
        lb1.setBounds(40,170,700,50);
        lb1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        add(lb1);
        lb1=new JLabel(".");
        lb1.setBounds(20,220,30,50);
        lb1.setFont(new Font("GREYSCALE",Font.BOLD,40));
        add(lb1);
        lb1=new JLabel("AN AUTONOMOUS GOVERNMENT COLLEGE.");
        lb1.setBounds(40,230,700,50);
        lb1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        add(lb1);
        lb1=new JLabel(".");
        lb1.setBounds(20,280,30,50);
        lb1.setFont(new Font("GREYSCALE",Font.BOLD,40));
        add(lb1);
        lb1=new JLabel("ALSO HOUSES HEADQUARTERS OF UPTU.");
        lb1.setBounds(40,290,700,50);
        lb1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        add(lb1);
        lb1=new JLabel(".");
        lb1.setBounds(20,340,30,50);
        lb1.setFont(new Font("GREYSCALE",Font.BOLD,40));
        add(lb1);
        lb1=new JLabel("ENTRANCE THROUGH UPSEE.");
        lb1.setBounds(40,350,700,50);
        lb1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        add(lb1);
        
        lb1=new JLabel("PROGRAMMED BY - ");
        lb1.setBounds(415,410,300,50);
        lb1.setFont(new Font("MONOTYPE CORSIVA",Font.PLAIN,15));
        add(lb1);
        lb1=new JLabel("ACHINT CHAUHAN");
        lb1.setBounds(548,410,700,50);
        lb1.setForeground(Color.MAGENTA);
        lb1.setFont(new Font("MONOTYPE CORSIVA",Font.PLAIN,15));
        add(lb1);
        lb1=new JLabel("                COLLEGE -");
        lb1.setBounds(420,430,700,50);
        lb1.setFont(new Font("MONOTYPE CORSIVA",Font.PLAIN,15));
        add(lb1);
        lb1=new JLabel("SEMESTER -");
        lb1.setBounds(458,450,700,50);
        lb1.setFont(new Font("MONOTYPE CORSIVA",Font.PLAIN,15));
        add(lb1);
        lb1=new JLabel("I.E.T LUCKNOW");
        lb1.setBounds(548,430,700,50);
        lb1.setForeground(Color.MAGENTA);
        lb1.setFont(new Font("MONOTYPE CORSIVA",Font.PLAIN,15));
        add(lb1);
        lb1=new JLabel("IInd SEMESTER(2016)");
        lb1.setBounds(548,450,700,50);
        lb1.setForeground(Color.MAGENTA);
        lb1.setFont(new Font("Century Gothic",Font.PLAIN,15));
        add(lb1);
        lb1=new JLabel("(PROGRAMMED IN JAVA)");
        lb1.setBounds(430,470,700,50);
        lb1.setForeground(Color.MAGENTA);
        lb1.setFont(new Font("MONOTYPE CORSIVA",Font.PLAIN,25));
        add(lb1);
        
        mbar = new JMenuBar();
        m1 = new JMenu("OPTIONS");
        m_item1 = new JMenuItem("SIGN UP");
        m_item1.addActionListener(this);
        m_item2 = new JMenuItem("LOGIN");
        m_item2.addActionListener(this);

        m1.add(m_item1);
        m1.add(m_item2);
        mbar.add(m1);
        setJMenuBar(mbar);

        pic = new JLabel();
        pic.setBounds(0, 0, 1300, 400);

        SetImageSize(4);

        tm = new Timer(1500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if (x >= list.length) {
                    x = 0;
                }
            }
        });
        add(pic);
        tm.start();

        setLayout(null);
        setBounds(0, 0, 768, 600);
        setTitle("STUDENT INVENTORY");
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void SetImageSize(int i) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    public void actionPerformed(ActionEvent e) {

        if ("SIGN UP".equals(e.getActionCommand())) {
            dispose();
            new Sign_up();
        } else if ("LOGIN".equals(e.getActionCommand())) {
            dispose();
            new project_login();

        }
    }

    public static void main(String[] arg) {
        new main();

    }
}
