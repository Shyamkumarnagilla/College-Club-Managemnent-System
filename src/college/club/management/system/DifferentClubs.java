package college.club.management.system;

import javax.swing.*;
import java.awt.*;

public class DifferentClubs extends JFrame {
    DifferentClubs(){

        JLabel heading = new JLabel("Different Clubs to Join");
        heading.setBounds(120,10,640,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        JPanel heading1 = new JPanel();
        heading1.setBounds(0,5,1545,45);
        heading1.setBackground(Color.gray);
        add(heading1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/diffclubs.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(15,55,600,700);
        add(img);

        setSize(640,820);
        setLocation(140,20);
        setTitle("Clubs Info");
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new DifferentClubs();
    }
}
