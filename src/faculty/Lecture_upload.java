package faculty;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import student.JdbcConnection;

public class Lecture_upload extends JFrame {

    JButton button, btn1;
    JButton button2;
    JLabel label;
    JTextField textID;
    JTextField textNAME;
    JTextArea area;
    public String lecture_up = null, s;

    public Lecture_upload(String o) {
        super("UPLOAD TIME TABLE FOR STUDENTS(NO PDF's)");
        lecture_up = o;

        button = new JButton("ADD");
        button.setBounds(200, 300, 100, 40);

        button2 = new JButton("Browse");
        button2.setBounds(80, 300, 100, 40);

        area = new JTextArea("NOTE", 100, 100);

        JScrollPane pane = new JScrollPane(area);
        pane.setBounds(450, 270, 200, 100);

        label = new JLabel();
        label.setBounds(10, 10, 670, 250);

        //button to browse the image into jlabel
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
                fileChooser.addChoosableFileFilter(filter);
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    label.setIcon(ResizeImage(path));
                    s = path;
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No Data");
                }
            }
        });

        //button to insert image and some data into mysql database
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = JdbcConnection.getConnection();
                    PreparedStatement ps = con.prepareStatement("insert into mytimetable(Description,Image) values(?,?)");
                    InputStream is = new FileInputStream(new File(s));
                    ps.setString(1, area.getText());
                    ps.setBlob(2, is);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Inserted");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btn1 = new JButton("BACK");
        btn1.setBounds(0, 0, 100, 20);
        add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Faculty_after_login(lecture_up);
                dispose();
            }
        });

        add(label);
        
        add(pane);
        add(button);
        add(button2);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 420);
        setVisible(true);
    }

    //Methode To Resize The ImageIcon
    public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    public static void main(String[] args) {
        String s = null;
        new Lecture_upload(s);
    }
}
