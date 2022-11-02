package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton submit,cancel;
    String formno;
    SignUpThree(String formno){
        this.formno = formno;

        setLayout(null);
        setSize(850,820);
        setLocation(200,0);
        setVisible(true);



        JLabel l1 = new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,20,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,80,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setBounds(100,120,200,20);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350,120,200,20);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setBounds(100,145,200,20);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350,145,300,20);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setBounds(100,200,200,30);
        card.setFont(new Font("Raleway",Font.BOLD,22));
        add(card);

        JLabel num = new JLabel("XXXX-XXXX-XXXX-9328");
        num.setBounds(310,200,300,30);
        num.setFont(new Font("Raleway",Font.BOLD,22));
        add(num);

        JLabel Cinfo = new JLabel("Your 16 digit Card no:");
        Cinfo.setBounds(100,225,200,15);
        Cinfo.setFont(new Font("Raleway",Font.BOLD,10));
        add(Cinfo);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(100,260,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);


        JLabel pass = new JLabel("XXXX");
        pass.setBounds(310,260,200,30);
        pass.setFont(new Font("Raleway",Font.BOLD,22));
        add(pass);

        JLabel pinfo = new JLabel("Your 4 digit password:");
        pinfo.setBounds(100,285,200,15);
        pinfo.setFont(new Font("Raleway",Font.BOLD,10));
        add(pinfo);


        JLabel service = new JLabel("Services Required :");
        service.setBounds(100,330,300,30);
        service.setFont(new Font("Raleway",Font.BOLD,22));
        add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(100,365,200,15);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.white);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(310,365,200,15);
        c2.setFont(new Font("Raleway",Font.BOLD,15));
        c2.setBackground(Color.white);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(520,365,200,15);
        c3.setFont(new Font("Raleway",Font.BOLD,15));
        c3.setBackground(Color.white);
        add(c3);


        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBounds(100,390,200,15);
        c4.setFont(new Font("Raleway",Font.BOLD,15));
        c4.setBackground(Color.white);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(310,390,200,15);
        c5.setFont(new Font("Raleway",Font.BOLD,15));
        c5.setBackground(Color.white);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(520,390,200,15);
        c6.setFont(new Font("Raleway",Font.BOLD,15));
        c6.setBackground(Color.white);
        add(c6);

        c7 = new JCheckBox("I hereby declare that above entered details are correct to the best of my Knowldege");
        c7.setBounds(100,500,600,15);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBackground(Color.white);
        add(c7);


        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(250,550,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBounds(420,550,100,30);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String accountType = null;
            if (r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType ="Fixed Deposit Account";

            }
            Random ran = new Random();
            String cardNo = "" + Math.abs((ran.nextLong() % 90000000) + 4679800000000000l);
            String pin = "" + Math.abs((ran.nextLong() & 9000l)+1000l);

            String facility ="";
            if (c1.isSelected()){
                facility = facility +" ATM Card";
            } else if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + " Emails & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }
            try {if (accountType.equals("")){
                JOptionPane.showMessageDialog(null,"Account type is Required");
            }else {
                Conn con = new Conn();
                String query3 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardNo+"','"+pin+"','"+facility+"')";
                con.s.executeUpdate(query3);

                String query4 ="insert into signin values('"+formno+"','"+cardNo+"','"+pin+"')";
                con.s.executeUpdate(query4);


                JOptionPane.showMessageDialog(null,"Card No.: "+cardNo +"\n"+"PIN : " + pin);

                setVisible(false);
                new deposit(pin).setVisible(false);
            }


            }catch (Exception e){
                System.out.println(e);
            }


        } else if (ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
