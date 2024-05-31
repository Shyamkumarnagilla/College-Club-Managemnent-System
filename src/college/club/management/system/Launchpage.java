package college.club.management.system;

import javax.swing.*;
import java.awt.*;

public class Launchpage extends JFrame implements Runnable {

    Thread t1;

    Launchpage() {

        //Adding image to the JFrame using JLable
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/launch.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        //JFrame creation
        setSize(1500, 800);
        setBounds(20,10,1500,800);
        setTitle("Launchpage");
        setVisible(true);

        //To perform some runnable action
        t1 = new Thread(this);
        t1.start();

    }

    public static void main(String[] args) {
        new Launchpage();
    }

    //Auto redirect to next page(Login page)
    public void run() {
        try {
            Thread.sleep(5000);
            setVisible(false);
            //next class-redirecting to next Action(Login page)
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
