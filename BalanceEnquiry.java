package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pin;
    BalanceEnquiry(String pin){
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        Conn c = new Conn();
        int balance =0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");

            while (rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }

            JLabel text = new JLabel("YOUR CURRENT ACCOUNT BALANCE IS RS " + balance);
            text.setForeground(Color.white);
            text.setBounds(170,300,400,30);
            image.add(text);


        setLayout(null);
        setBounds(200,0,900,900);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Transaction(pin).setVisible(true);
    }

    public static void main(String[] args) {
       new  BalanceEnquiry("");
    }
}
