package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    String pin;
    FastCash(String pin){
        setLayout(null);
        this.pin=pin;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(235,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        b1 = new JButton("Rs 100");
        b1.setBounds(170,415,150,30);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs 200");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        image.add(b2);

        b3= new JButton("Rs 500");
        b3.setBounds(170,450,150,30);
       b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs 1000");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(170,485,150,30);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("BACK");
        b7.setBounds(355,520,150,30);
        b7.addActionListener(this);
        image.add(b7);



        setSize(900,900);
        setLocation(200,-0);
        setVisible(true);

        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
               new Transaction(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
