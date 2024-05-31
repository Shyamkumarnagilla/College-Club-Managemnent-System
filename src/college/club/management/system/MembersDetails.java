package college.club.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MembersDetails extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton search, add, update, print, cancel;
    MembersDetails(){
        //Area to show search by roll number-creation
        getContentPane().setBackground(new Color(228, 164, 204));

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,220,25);
        heading.setFont(new Font("serif",Font.BOLD,20));

        add(heading);

        //choice selection area-creation
        choice = new Choice();
        choice.setBounds(260,20,150,20);
        add(choice);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from members");
            while(resultSet.next()){
                choice.add(resultSet.getString("rollNo"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //Displaying the data from db in table formate
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from members");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0,100,900,600);
        add(js);

        //Search Button
        search =new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        //Add Button
        add =new JButton("Add");
        add.setBounds(120,70,80,20);
        add.addActionListener(this);
        add(add);

        //Update Button
        update =new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        //Print Button
        print =new JButton("Print");
        print.setBounds(320,70,80,20);
        print.addActionListener(this);
        add(print);

        //Cancel Button
        cancel =new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);


        setLayout(null);
        setSize(900,700);
        setLocation(300,100);
        setTitle("Members details");
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String q = "select * from members where rollno ='"+choice.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == add) {
            new Addmembers();
        }  else if (e.getSource() == update) {
            new UpdDetails();

        }else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else  {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MembersDetails();
    }
}
