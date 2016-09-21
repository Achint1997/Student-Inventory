package student;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import student.JdbcConnection;


public class Work_display extends JFrame implements ActionListener{
    JButton button;
    JLabel label;
    JTextField jtf;
    Connection con;
    
    public Work_display(){
        button =new JButton("retrieve");
        button.setBounds(150,300,100,30);
        add(button);
        button.addActionListener(this);
        jtf=new JTextField();
        jtf.setBounds(260,300,100,30);
        add(jtf);
        label=new JLabel();
        label.setBounds(10,10,500,250);
        add(label);
        
        setLayout(null);
        setBounds(30,30,1000,500);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            con=JdbcConnection.getConnection();
            Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery("select image from myimage where ID='"+jtf.getText()+"'");
            if(res.next()){
                byte[] img=res.getBytes("image");
                ImageIcon image=new ImageIcon(img);
                Image im=image.getImage();
                Image myImg=im.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage=new ImageIcon(myImg);
                label.setIcon(newImage);
            }
        }
        catch(Exception ex){
            
        }
    }
        public static void main(String []arg){
            new Work_display();
        }
}
