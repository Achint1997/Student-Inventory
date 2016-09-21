
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class Radiobutton extends JFrame {

    RadioButton rd1, rd2;
    ButtonGroup bg;

    public Radiobutton() {
        JRadioButton male = new JRadioButton("male");
        male.setActionCommand("male");
        JRadioButton female = new JRadioButton("Female");
        female.setActionCommand("Female");
        ButtonGroup bG = new ButtonGroup();
        bG.add(male);
        bG.add(female);
        this.add(male);
        this.add(female);
        male.setSelected(true);
        this.setSize(100, 200);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        System.out.println(bG.getSelection().getActionCommand());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                return;
            }
        });
        
    }

    public static void main(String[] arg) {
        new Radiobutton();
    }
}
