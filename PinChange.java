package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField newPin,renewPin;
    JButton change,back;

    String pin;
    PinChange(String pin){
        this.pin=pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,180,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(165,320,180,25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.white);
        image.add(pintext);

        newPin = new JPasswordField();
        newPin.setBounds(330,320,180,25);
        newPin.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(newPin);

        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165,360,300,25);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setForeground(Color.white);
        image.add(repintext);

        renewPin = new JPasswordField();
        renewPin.setBounds(330,360,180,25);
        renewPin.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(renewPin);

        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);


        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(200,-0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==change){
        try {
            String npin = newPin.getText();
            String rpin = renewPin.getText();

            if (!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered PIN doesn't match");
                return;
            }
            if (npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter new PIN");
            }
            if (rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter PIN");
            }

            Conn c = new Conn();
            String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"'";
            String query2 = "update signin set pin = '"+rpin+"' where pin = '"+pin+"'";
            String query3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"'";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
            setVisible(false);
            new Transaction(rpin).setVisible(true);


        }catch (Exception e){
            System.out.println(e);
        }}
        else {
            setVisible(false);
            new Transaction("pin").setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
