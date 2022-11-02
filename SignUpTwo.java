
package BankManagementSystem;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class SignUpTwo extends JFrame implements ActionListener {

    long random;
    JTextField PTextField,ATextField;
    JComboBox Religion,Category,Income,Educational,occupation;

    JRadioButton yes,no,syes,sno;
    JButton next;
    String formno;
    SignUpTwo(String formno){
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM 2");


        JLabel additionalDetails = new JLabel("Page 2: Additional Details" );
        additionalDetails.setBounds(290,80,600,30);
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        add(additionalDetails);




        JLabel religion= new JLabel("Religion:");
        religion.setBounds(100,140,100,30);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        add(religion);

        String ValReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        Religion =new JComboBox(ValReligion);
        Religion.setBounds(300,140,300,30);
        Religion.setFont(new Font("Raleway",Font.BOLD,14));
        Religion.setBackground(Color.white);
        add(Religion);


        JLabel category= new JLabel("Category:");
        category.setBounds(100,180,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        add(category);

        String ValCategory[]={"General","OBC","SC","ST","Other"};
        Category =new JComboBox(ValCategory);
        Category.setBounds(300,180,300,30);
        Category.setFont(new Font("Raleway",Font.BOLD,14));
        Category.setBackground(Color.white);
        add(Category);

        JLabel income = new JLabel("Income:");
        income.setBounds(100,220,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);




        String ValIncome[]={"null","<1L","<2.5l","<5l","Above 5l"};
        Income =new JComboBox(ValIncome);
        Income.setBounds(300,220,300,30);
        Income.setFont(new Font("Raleway",Font.BOLD,14));
        Income.setBackground(Color.white);
        add(Income);




        JLabel educational= new JLabel("Educational:");
        educational.setBounds(100,260,200,30);
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        add(educational);


        JLabel quali= new JLabel(" Qualification:");
        quali.setBounds(100,290,200,30);
        quali.setFont(new Font("Raleway",Font.BOLD,20));
        add(quali);

        String ValEdu[] =  {"Graduate","Non Graduation", "PostGraduate","Doctorate","Other"};
        Educational = new JComboBox(ValEdu);
        Educational.setBounds(300,275,300,30);
        Educational.setFont(new Font("Raleway",Font.BOLD,14));
        Educational.setBackground(Color.white);
        add(Educational);

        JLabel Occupation= new JLabel("Occupation:");
        Occupation.setBounds(100,340,200,30);
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(Occupation);


        String OccupationValue[] ={ "Salaried","Student","Self-Employed","Businessman","Retired","Other"};
        occupation = new JComboBox<>(OccupationValue);
        occupation.setBounds(300,340,300,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,14));
        occupation.setBackground(Color.white);
        add(occupation);




        JLabel Pan= new JLabel("PAN:");
        Pan.setBounds(100,380,200,30);
        Pan.setFont(new Font("Raleway",Font.BOLD,20));
        add(Pan);

        PTextField = new JTextField();
        PTextField.setBounds(300,380,300,30);
        PTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(PTextField);

        JLabel aadhar= new JLabel("AADHAR No:");
        aadhar.setBounds(100,420,200,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadhar);

        ATextField = new JTextField();
        ATextField.setBounds(300,420,300,30);
        ATextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(ATextField);

        JLabel Senior = new JLabel("Senior Citizen:");
        Senior.setBounds(100,460,200,30);
        Senior.setFont(new Font("Raleway",Font.BOLD,20));
        add(Senior);

        yes = new JRadioButton("Yes");
        yes.setBounds(300,460,60,30);
        yes.setFont(new Font("Raleway",Font.BOLD,14));
        yes.setBackground(Color.white);
        add(yes);



        no = new JRadioButton("No");
        no.setBounds(400,460,60,30);
        no.setFont(new Font("Raleway",Font.BOLD,14));
        no.setBackground(Color.white);
        add(no);




        ButtonGroup citizen = new ButtonGroup();
        citizen.add(yes);
        citizen.add(no);



        JLabel EAccount= new JLabel("Existing Account:");
        EAccount.setBounds(100,500,200,30);
        EAccount.setFont(new Font("Raleway",Font.BOLD,20));
        add(EAccount);


        syes = new JRadioButton("Yes");
        syes.setBounds(300,500,100,30);
        syes.setBackground(Color.white);
        add(syes);


        sno = new JRadioButton("No");
        sno.setBounds(400,500,60,30);
        sno.setBackground(Color.white);
        add(sno);


        ButtonGroup Existing = new ButtonGroup();
        Existing.add(syes);
        Existing.add(sno);


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
        String sreligion = (String) Religion.getSelectedItem();
        String scategory= (String) Category.getSelectedItem();
        String sincome = (String) Income.getSelectedItem();
        String seducational = (String) Educational.getSelectedItem();
        String soccuoation = (String) occupation.getSelectedItem();
        String saadhar = ATextField.getText();
        String span = PTextField.getText();

        String SeniorCitizen = null;
        if (yes.isSelected()){
            SeniorCitizen = "Yes";
        } else if (no.isSelected()) {
            SeniorCitizen ="no";
        }

        String ExistingAccount  = null;
        if (syes.isSelected()){
            ExistingAccount = "yes";
        } else if (sno.isSelected()) {
            ExistingAccount= "No";
        }




        try {
            Conn c = new Conn();
                String query2 ="insert into signup2 values('"+formNo+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducational+"','"+soccuoation+"','"+saadhar+"','"+span+"','"+SeniorCitizen+"','"+ExistingAccount+"')";
                c.s.executeUpdate(query2);

                setVisible(false);
                new SignUpThree(formno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        new SignUpTwo("");

    }

}
