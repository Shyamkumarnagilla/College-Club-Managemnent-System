package college.club.management.system;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Addmembers extends JFrame implements ActionListener {

    JTextField textName, textFname, textAdd, textPhn, textMail;
    JLabel rollText;
    JDateChooser cdob;
    JComboBox yrBox, branchBox, clubBox;
    JButton submit, cancel;

    Random rand = new Random();
    long f1 = Math.abs((rand.nextLong() % 10000L) + 1000L);
    Addmembers(){

        getContentPane().setBackground(new Color(0, 204, 204));


        JLabel heading = new JLabel("New Member Details");
        heading.setBounds(250,50,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,200,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(180,150,150,30);
        add(textName);

        //Father Name
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(450,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        textFname = new JTextField();
        textFname.setBounds(600,150,150,30);
        add(textFname);

        //Roll Number
        JLabel rollNo = new JLabel("Roll No");
        rollNo.setBounds(50,250,200,30);
        rollNo.setFont(new Font("serif",Font.BOLD,20));
        add(rollNo);

        rollText = new JLabel("217Q1A"+f1);
        rollText.setBounds(180,250,150,30);
        rollText.setFont(new Font("serif",Font.BOLD,20));
        add(rollText);

        //Date of Birth
        JLabel dob = new JLabel("DOB");
        dob.setBounds(450,250,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600,250,150,30);
        cdob.setFont(new Font("serif",Font.BOLD,20));
        add(cdob);

        //Year
        JLabel yr = new JLabel("Year");
        yr.setBounds(50,350,200,30);
        yr.setFont(new Font("serif",Font.BOLD,20));
        add(yr);

        String year[] = {"1-1","1-2","2-1","2-2","3-1","3-2","4-1","4-2"};
        yrBox = new JComboBox(year);
        yrBox.setBounds(180,350,150,30);
        yrBox.setBackground(Color.white);
        add(yrBox);

        //Branch
        JLabel br = new JLabel("Branch");
        br.setBounds(450,350,200,30);
        br.setFont(new Font("serif",Font.BOLD,20));
        add(br);

        String branch[] = {"CSE","ECE","EEE","ME","CE","IT","AE"};
        branchBox = new JComboBox(branch);
        branchBox.setBounds(600,350,150,30);
        branchBox.setBackground(Color.white);
        add(branchBox);

        //Address
        JLabel adrs = new JLabel("Address");
        adrs.setBounds(50,450,200,30);
        adrs.setFont(new Font("serif",Font.BOLD,20));
        add(adrs);

        textAdd = new JTextField();
        textAdd.setBounds(180,450,150,30);
        add(textAdd);

        //Phone Number
        JLabel phn = new JLabel("Phone");
        phn.setBounds(450,450,200,30);
        phn.setFont(new Font("serif",Font.BOLD,20));
        add(phn);

        textPhn = new JTextField();
        textPhn.setBounds(600,450,150,30);
        add(textPhn);

        //Email
        JLabel email = new JLabel("Email");
        email.setBounds(50,550,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textMail = new JTextField();
        textMail.setBounds(180,550,150,30);
        add(textMail);

        //Club
        JLabel club = new JLabel("Choose Club");
        club.setBounds(450,550,200,30);
        club.setFont(new Font("serif",Font.BOLD,20));
        add(club);

        String clubs[] = {"Academic","Political","Media/Publications","Commumity Service","Arts/Theater"};
        clubBox = new JComboBox(clubs);
        clubBox.setBounds(600,550,150,30);
        clubBox.setBackground(Color.white);
        add(clubBox);

        //Submit Button
        submit = new JButton("Submit");
        submit.setBounds(200,680,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        //Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(480,680,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        //JFrame creation
        setSize(800,800);
        setLocation(350,10);
        setTitle("Join Club");
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String name = textName.getText();
            String fname = textFname.getText();
            String rollno = rollText.getText();
            String dob = ((JTextField)cdob.getDateEditor().getUiComponent()).getText();
            String year = (String) yrBox.getSelectedItem();
            String branch =(String) branchBox.getSelectedItem();
            String address = textAdd.getText();
            String phone = textPhn.getText();
            String email = textMail.getText();
            String club = (String) clubBox.getSelectedItem();
            try{
                String q = "insert into members values('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+year+"','"+branch+"','"+address+"','"+phone+"','"+email+"','"+club+"')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details inserted successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Addmembers();
    }
}
