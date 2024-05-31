package college.club.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/home.png"));
        Image i2 = i1.getImage().getScaledInstance(1440,820,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        //Menu bar creation
        JMenuBar mb= new JMenuBar();
        mb.setBackground(new Color(55, 155, 231));
        mb.setPreferredSize(new Dimension(1540, 30));


        //Club Info
        JMenu clubInfo = new JMenu(" Clubs Information");
        clubInfo.setForeground(Color.BLACK);
        mb.add(clubInfo);

        JMenuItem diffClubInfo = new JMenuItem("Different Clubs");
        diffClubInfo.setBackground(Color.white);
        diffClubInfo.addActionListener(this);
        clubInfo.add(diffClubInfo);

        //Members
        JMenu memInfo = new JMenu(" Club Members ");
        memInfo.setForeground(Color.BLACK);
        mb.add(memInfo);

        JMenuItem academicInfo = new JMenuItem("Join Club");
        academicInfo.setBackground(Color.white);
        academicInfo.addActionListener(this);
        memInfo.add(academicInfo);

        //Events
        JMenu eventInfo = new JMenu(" Events ");
        eventInfo.setForeground(Color.BLACK);
        mb.add(eventInfo);

        JMenuItem eventsInfo = new JMenuItem("NEWS");
        eventsInfo.setBackground(Color.white);
        eventsInfo.addActionListener(this);
        eventInfo.add(eventsInfo);

        //Update details
        JMenu updateInfo = new JMenu(" Members Details ");
        updateInfo.setForeground(Color.BLACK);
        mb.add(updateInfo);

        JMenuItem updInfo = new JMenuItem("Update and Info");
        updInfo.setBackground(Color.white);
        updInfo.addActionListener(this);
        updateInfo.add(updInfo);

        //About
        JMenu aboutInfo = new JMenu(" About ");
        aboutInfo.setForeground(Color.BLACK);
        mb.add(aboutInfo);

        JMenuItem about = new JMenuItem("About");
        about.setBackground(Color.white);
        about.addActionListener(this);
        aboutInfo.add(about);

        //Exit
        JMenu exit = new JMenu(" Exit ");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);



        setJMenuBar(mb);



        setSize(1540,850);
        setTitle("Home");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if (sm.equals("Different Clubs")) {
            new DifferentClubs();
        } else if (sm.equals("Join Club")) {
            new Addmembers();
        } else if (sm.equals("NEWS")) {
            new News();
        } else if (sm.equals("Update and Info")) {
            new MembersDetails();
        } else if (sm.equals("About")) {
            new About();
        } else if (sm.equals("Exit")) {
            System.exit(15);
        }

    }

    public static void main(String[] args) {
        new main_class();
    }
}
