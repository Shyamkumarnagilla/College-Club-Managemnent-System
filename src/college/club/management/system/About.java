package college.club.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    About(){

        JLabel heading = new JLabel("<html>About College Club Management</html>");
        heading.setBounds(90,80,900,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,40));
        add(heading);

        JLabel name = new JLabel("<html>&emsp;&emsp; Welcome to the College Club Management System , your one-stop solution for managing college clubs efficiently. Our management system offers a centralized system for club  members to organize, communicate, and coordinate club activities seamlessly. With features like club registration, member management, event scheduling, communication tools,  and resource management. We aim to enhance the overall experience and productivity of college clubs.<br>&emsp;&emsp; Join us in fostering a vibrant campus community through effective club management. </html>");
        name.setBounds(55,150,1000,200);
        name.setFont(new Font("",Font.PLAIN,20));
        add(name);

        JLabel contact = new JLabel("Contact details");
        contact.setBounds(70,400,550,35);
        contact.setFont(new Font("Tahoma",Font.BOLD,30));
        add(contact);

        JLabel address = new JLabel("<html>collegeclub@gmail.com <br> +91 939010XXXX <br> +91 987654XXXX</html>");
        address.setBounds(100,420,550,120);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        JPanel bluepan = new JPanel();
        bluepan.setSize(1100,210);
        bluepan.setBounds(0,390,1100,600);
        bluepan.setBackground(new Color(192, 161, 224));
        bluepan.setVisible(true);
        add(bluepan);


        setSize(1100,600);
        setLocation(190,80);
        setTitle("About");
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new About();
    }
}
