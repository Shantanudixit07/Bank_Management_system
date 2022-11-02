package BankManagementSystem;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField NameTextField,FTextField,ETextField,CTextField,PTextField,ATextField,STextField;
    JDateChooser Datechhoser;
    JRadioButton male,female,married,Unmarried ,other;
    JButton next;
    SignUpOne(){
        Random rc = new Random();
        random = Math.abs((rc.nextLong() % 9000l) + 1000l);

        JLabel formNo = new JLabel("APPLICATION FORM NO :" + " " + random);
        formNo.setBounds(140,20,600,40);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        add(formNo);

        JLabel personalDetails = new JLabel(" Page 1: Personal Details" );
        personalDetails.setBounds(290,80,600,30);
        personalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        add(personalDetails);



        JLabel name= new JLabel("Name:");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);

        NameTextField = new JTextField();
        NameTextField.setBounds(300,140,300,30);
        NameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(NameTextField);


        JLabel Fname= new JLabel("Father's Name:");
        Fname.setBounds(100,180,200,30);
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(Fname);

        FTextField = new JTextField();
        FTextField.setBounds(300,180,300,30);
        FTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(FTextField);

        JLabel dob= new JLabel("DOB:");
        dob.setBounds(100,220,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);

        Datechhoser = new JDateChooser();
        Datechhoser.setBounds(300,220,300,30);
        Datechhoser.setForeground(new Color(105,105,105));
        add(Datechhoser);


        JLabel gender= new JLabel("Gender:");
        gender.setBounds(100,260,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,260,100,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,260,100,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        JLabel email= new JLabel("E-mail:");
        email.setBounds(100,300,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        add(email);

        ETextField = new JTextField();
        ETextField.setBounds(300,300,300,30);
        ETextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(ETextField);

        JLabel marital= new JLabel("Marital status:");
        marital.setBounds(100,340,200,30);
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,340,100,30);
        married.setBackground(Color.white);
        add(married);

        Unmarried = new JRadioButton("Unmarried");
        Unmarried.setBounds(400,340,100,30);
        Unmarried.setBackground(Color.white);
        add(Unmarried);


        other = new JRadioButton("Other");
        other.setBounds(500,340,60,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup martialGroup = new ButtonGroup();
        martialGroup.add(married);
        martialGroup.add(Unmarried);
        martialGroup.add(other);




        JLabel address= new JLabel("Address:");
        address.setBounds(100,380,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);

        ATextField = new JTextField();
        ATextField.setBounds(300,380,300,30);
        ATextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(ATextField);

        JLabel city= new JLabel("City:");
        city.setBounds(100,420,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);

        CTextField = new JTextField();
        CTextField.setBounds(300,420,300,30);
        CTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(CTextField);

        JLabel State = new JLabel("State:");
        State.setBounds(100,460,200,30);
        State.setFont(new Font("Raleway",Font.BOLD,20));
        add(State);

        STextField = new JTextField();
        STextField.setBounds(300,460,300,30);
        STextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(STextField);

        JLabel pincode= new JLabel("Pincode:");
        pincode.setBounds(100,500,200,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincode);

        PTextField = new JTextField();
        PTextField.setBounds(300,500,300,30);
        PTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(PTextField);


        next = new JButton("Next");
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.setBounds(540,600,80,30);
        next.addActionListener(this);
        add(next);





        setLayout(null);
        setSize(850,800);
        setLocation(250,0);
        setVisible(true);


        getContentPane().setBackground(Color.white);
    }



    public void actionPerformed(ActionEvent ae){
        String formNo = "" + random;
        String name = NameTextField.getText();
        String fathersName = FTextField.getText();
        String dob =((JTextField) Datechhoser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender ="Female";
        }
        String email = ETextField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        } else if (Unmarried.isSelected()) {
            marital = " Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        String address = ATextField.getText();
        String city = CTextField.getText();
        String state = STextField.getText();
        String pincode = PTextField.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"name is required");
            } else  {
                Conn c = new Conn();
                String query ="insert into signup1 values('"+formNo+"','"+name+"','"+fathersName+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        new SignUpOne();

    }

}
