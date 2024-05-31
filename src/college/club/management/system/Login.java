package college.club.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    //Gloabal variables declaration
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login, back;

    //Constructor
    Login(){

        //JLable is used to add text on JFrame (Here Username is texted)
        JLabel labelName = new JLabel("Username");
        labelName.setBounds(40,20,100,20);
        labelName.setForeground(Color.WHITE);
        add(labelName);

        //Creating area to enter the Username
        textFieldName = new JTextField();
        textFieldName.setBounds(150,20,150,20);
        add(textFieldName);

        //Password text to set in JFrame
        JLabel labelpass = new JLabel("Password");
        labelpass.setBounds(40,70,100,20);
        labelpass.setForeground(Color.WHITE);
        add(labelpass);

        //Creating area to enter the password
        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,20);
        add(passwordField);

        //Buttons creation and there action
        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(180,140,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //Adding image in frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,550,250);
        add(img);

        //Frame creation
        setSize(550,250);
        setLocation(500,250);
        setTitle("Login");
        setLayout(null);
        setVisible(true);

    }

    //we are overriding since we used actionlisteners to perform some action when we press login or back button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            String username = textFieldName.getText();
            String password = passwordField.getText();

            String query = "select * from login where username='"+username+"' and password = '"+password+"'";
            try{
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    //next class
                    new main_class();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
