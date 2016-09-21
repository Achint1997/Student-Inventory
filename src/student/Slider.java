/*
 * To change this license header, choose License Headers in Slider Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Slider extends JFrame {

    JLabel pic;
    Timer tm;
    int x = 0;
    //Images Path In Array
    String[] list = {
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\1a.png",
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\2a.png",
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\3a.png",
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\4a.jpg",
        "C:\\Users\\HP\\Documents\\NetBeansProjects\\project\\5a.jpg",};

    public Slider() {
        super("Java SlideShow");
        pic = new JLabel();
        pic.setBounds(0, 0, 1300, 400);

        //Call The Function SetImageSize
        SetImageSize(4);

        //set a timer
        tm = new Timer(500, new ActionListener() {

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

    }

    //create a function to resize the image 
    public void SetImageSize(int i) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    public static void main(String[] args) {

        Slider s = new Slider();
        s.setLayout(null);
        s.setSize(500, 500);
        s.getContentPane().setBackground(Color.decode("#bdb67b"));
        s.setLocationRelativeTo(null);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setVisible(true);
    }
}
