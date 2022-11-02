package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,signup;
    JTextField CardTextField;
    JPasswordField PinTextField;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label1 = new JLabel(i3);
        label1.setBounds(170,10,100,100);
        add(label1);

        JLabel text = new JLabel("Welcome TO ATM");
        text.setBounds(270,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        JLabel CardNo = new JLabel("Card Number:");
        CardNo.setBounds(120,150,250,30);
        CardNo.setFont(new Font("Raleway",Font.BOLD,28));
        add(CardNo);

        CardTextField = new JTextField();
        CardTextField.setBounds(350,150,300,30);
        CardTextField.setFont(new Font("Arial" ,Font.BOLD,14));
        add(CardTextField);


        JLabel pin = new JLabel("PIN :");
        pin.setBounds(120,220,100,30);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);

        PinTextField = new JPasswordField();
        PinTextField.setBounds(350,220,300,30);
        PinTextField.setFont(new Font("Arial" ,Font.BOLD,14));
        add(PinTextField);

        login = new JButton("Login");
        login.setBounds(350,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(550,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Signup");
        signup.setBounds(350,350,300,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(270,100);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear){
            CardTextField.setText("");
            PinTextField.setText("");

        } else if (ae.getSource()==login) {
            Conn conn = new Conn();
            String Cardno = CardTextField.getText();
            String pin= PinTextField.getText();
            String query5 = "select * from signin where CardNo = '"+Cardno+"' and pin = '"+pin+"' ";

            try {
                ResultSet rs =conn.s.executeQuery(query5);
                if (rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
                }

            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==signup) {
            setVisible(false);

            new SignUpOne().setVisible(true);


        }

    }
    public static void main(String[] args) {
        new Login();

    }
}
