package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame  {
    String pin;
    MiniStatement(String pin){
        this.pin=pin;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel  Bank = new JLabel("Indian Bank");
        Bank.setBounds(150,20,100,20);
        add(Bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);


        try {Conn c = new Conn();
            int bal =0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Amount Balance is Rs +" + bal);

        }catch (Exception e){
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from signin where pin ='"+pin+"'");
            while (rs.next()){
                card.setText("Card Number: " + rs.getString("cardNo").substring(0,4)+"XXXXXXXX"+rs.getString("cardNo").substring(12));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from bank where pin ='"+pin+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount") + "<br><br>");
            }

        }catch (Exception e){
            System.out.println(e);
        }


        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
