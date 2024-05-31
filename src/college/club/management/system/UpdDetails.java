package college.club.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdDetails extends JFrame implements ActionListener {
    JTextField textYear, textBranch, textAdd, textPhn, textMail, textClub;
    JLabel rollText;
    JButton update, cancel;
    Choice cROLLNO;
    UpdDetails(){
        getContentPane().setBackground(new Color(231, 222, 185, 254));

        JLabel heading = new JLabel("Update Member Details");
        heading.setBounds(250,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel rollNO = new JLabel("Select Roll Number");
        rollNO.setBounds(50,100,230,20);
        rollNO.setFont(new Font("serif",Font.PLAIN,20));
        add(rollNO);

        cROLLNO = new Choice();
        cROLLNO.setBounds(280,100,150,20);
        add(cROLLNO);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from members");
            while (resultSet.next()){
                cROLLNO.add(resultSet.getString("rollNo"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,200,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(180,150,150,30);
        add(textName);

        //Father Name
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(450,150,200,30);
        fname.setFont(new Font("serif",Font.BOLD,20));
        add(fname);

        JLabel textFname = new JLabel();
        textFname.setBounds(600,150,150,30);
        add(textFname);

        //Roll Number
        JLabel ROLLNO = new JLabel("Roll No");
        ROLLNO.setBounds(50,250,200,30);
        ROLLNO.setFont(new Font("serif",Font.BOLD,20));
        add(ROLLNO);

        rollText = new JLabel();
        rollText.setBounds(180,250,150,30);
        rollText.setFont(new Font("serif",Font.BOLD,20));
        add(rollText);

        //Date of Birth
        JLabel dob = new JLabel("DOB");
        dob.setBounds(450,250,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel dobb = new JLabel();
        dobb.setBounds(600,250,150,30);
        dobb.setFont(new Font("serif",Font.BOLD,20));
        add(dobb);

        //Year
        JLabel year = new JLabel("Year");
        year.setBounds(50,350,200,30);
        year.setFont(new Font("serif",Font.BOLD,20));
        add(year);

        textYear = new JTextField();
        textYear.setBounds(180,350,150,30);
        add(textYear);

        //Branch
        JLabel branch = new JLabel("Branch");
        branch.setBounds(450,350,200,30);
        add(branch);

        textBranch= new JTextField();
        textBranch.setBounds(600,350,150,30);
        textBranch.setBackground(Color.white);
        add(textBranch);

        //Address
        JLabel address = new JLabel("Address");
        address.setBounds(50,450,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAdd = new JTextField();
        textAdd.setBounds(180,450,150,30);
        add(textAdd);

        //Phone Number
        JLabel phone = new JLabel("Phone");
        phone.setBounds(450,450,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

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

        textClub = new JTextField();
        textClub.setBounds(600,550,150,30);
        add(textClub);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from members where rollNo= '"+cROLLNO.getSelectedItem()+"'");
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textFname.setText(resultSet.getString("fname"));
                dobb.setText(resultSet.getString("dob"));
                textYear.setText(resultSet.getString("year"));
                textBranch.setText(resultSet.getString("branch"));
                textAdd.setText(resultSet.getString("address"));
                textPhn.setText(resultSet.getString("phone"));
                textMail.setText(resultSet.getString("email"));
                textClub.setText(resultSet.getString("club"));
                rollText.setText(resultSet.getString("rollNo"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cROLLNO.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from members where rollNo= '"+cROLLNO.getSelectedItem()+"'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textFname.setText(resultSet.getString("fname"));
                        dobb.setText(resultSet.getString("dob"));
                        textYear.setText(resultSet.getString("year"));
                        textBranch.setText(resultSet.getString("branch"));
                        textAdd.setText(resultSet.getString("address"));
                        textPhn.setText(resultSet.getString("phone"));
                        textMail.setText(resultSet.getString("email"));
                        textClub.setText(resultSet.getString("club"));
                        rollText.setText(resultSet.getString("rollNo"));
                    }
                    }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        //Submit Button
        update = new JButton("Update");
        update.setBounds(200,680,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

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
        setTitle("Update");
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update){
            String rollNo = rollText.getText();
            String address = textAdd.getText();
            String phone = textPhn.getText();
            String email = textMail.getText();
            String year = textYear.getText();
            String branch = textBranch.getText();
            String club = textClub.getText();

            try{
                String Q ="update members set year = '"+year+"', branch = '"+branch+"', address = '"+address+"',phone = '"+phone+"', email = '"+email+"', club = '"+club+"' where rollNo = '"+rollNo+"'";
                Conn c = new Conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdDetails();
    }
}
