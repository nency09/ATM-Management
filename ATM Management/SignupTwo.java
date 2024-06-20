import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class SignupTwo extends JFrame implements ActionListener{

    JTextField panTextField,AadharTextField,pinCodeTextField;
    JButton next;
    JRadioButton eyes,eno,syes,sno;
    JComboBox ocu,edu,rel,cat,inc;
    String formno;

    SignupTwo(String formno){

        this.formno = formno;
        setLayout(null);
        setTitle("New ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,28));
        additionalDetails.setBounds(270,80,400, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100, 30);
        add(religion);

        String []valReligion = {"Hindu","Jain","Christian","Sikh","Muslim","Other"};
        rel = new JComboBox(valReligion);
        rel.setBounds(300,140,400,30);
        rel.setBackground(Color.white);
        
        add(rel);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,150, 30);
        add(category);

        String []valCategory = {"General","OBC","SC","ST"};
        cat = new JComboBox(valCategory);
        cat.setBounds(300,190,400,30);
        cat.setBackground(Color.white);
        add(cat);

        JLabel income = new JLabel("Income:");
        income.setBounds(100,240,150, 30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);

        String []valIncome = {"Null","< 1,50,00","<2,00,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        inc = new JComboBox(valIncome);
        inc.setBounds(300, 240, 400,30);
        inc.setBackground(Color.white);
        add(inc);
        

        JLabel education = new JLabel("Educational: ");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,150, 30);
        add(education);

        JLabel qualification = new JLabel("Qualitfication:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,150, 30);
        add(qualification);

        String []valedu = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        edu = new JComboBox(valedu);
        edu.setBounds(300, 315, 400,30);
        edu.setBackground(Color.white);
        add(edu);


        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,150, 30);
        add(occupation);

        String []valocu = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        ocu = new JComboBox(valocu);
        ocu.setBounds(300, 390, 400,30);
        ocu.setBackground(Color.white);
        add(ocu);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,150, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel aadharno = new JLabel("Aadhar Number:");
        aadharno.setFont(new Font("Raleway",Font.BOLD,20));
        aadharno.setBounds(100,490,200, 30);
        add(aadharno);

        AadharTextField = new JTextField();
        AadharTextField.setBounds(300,490,400,30);
        AadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(AadharTextField);

        JLabel senior_citizen = new JLabel("Senior Citizen: ");
        senior_citizen.setBounds(100,540,150, 30);
        senior_citizen.setFont(new Font("Raleway",Font.BOLD,20));
        add(senior_citizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.cyan);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540,100, 30);
        sno.setBackground(Color.cyan);
        add(sno);

        ButtonGroup scgroup = new ButtonGroup(); // to select one from the above we have to group them all.
        scgroup.add(syes);
        scgroup.add(sno);

        JLabel exisiting_acc = new JLabel("Existing Account: ");
        exisiting_acc.setBounds(100,590,200, 30);
        exisiting_acc.setFont(new Font("Raleway",Font.BOLD,20));
        add(exisiting_acc);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.cyan);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590,100, 30);
        eno.setBackground(Color.cyan);
        add(eno);

        ButtonGroup eagroup = new ButtonGroup(); // to select one from the above we have to group them all.
        eagroup.add(eyes);
        eagroup.add(eno);

        JButton next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.CYAN);  //color is in awt class



        // create frame
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String)rel.getSelectedItem(); // getSe.. returns an object
        String scategory = (String)cat.getSelectedItem();
        String sincome = (String)inc.getSelectedItem();
        String seducation = (String)edu.getSelectedItem();
        String soccupation = (String)ocu.getSelectedItem();
        
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        }else if(sno.isSelected()){
            seniorCitizen = "No";
        }

        String existingAcc = null;
        if(eyes.isSelected()){
            existingAcc = "Yes";
        }else if(eno.isSelected()){
            existingAcc = "No";
        }

        String pan = panTextField.getText();
        String adh = AadharTextField.getText();

        String address = panTextField.getText();
        String city = AadharTextField.getText();

        //  ENTER MORE VALIDATIONS
        try{
            Conn c = new Conn();        // for keeping var as Strign--> "String'" + var + "'String";
            String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+pan+"','"+adh+"','"+seniorCitizen+"','"+existingAcc+"')";                       
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }
}
 
