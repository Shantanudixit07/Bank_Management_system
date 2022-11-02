package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw,back;
    JTextField amount;
    String pin;
    Withdrawl(String pin){
        this.pin =pin;

        setLayout(null);
        setBounds(200,0,900,900);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the Amount you want to Withdrawl");
        text.setBounds(170,300,400,20);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==withdraw){
            String num = amount.getText();
            Date date = new Date();
            if(num.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount ,you want to withdraw");
            }else {
                try {Conn c = new Conn();
                    String query ="insert into bank values('"+pin+"','"+date+"','Withdrawl','"+num+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs"+ num + " Withdraw Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);

                }catch (Exception e){
                    System.out.println(e);
                }
            }

        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);


        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}

