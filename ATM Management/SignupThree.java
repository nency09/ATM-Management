import java.awt.event.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;

class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton sacc,facc,cacc,racc;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        setSize(850,820);
        setTitle("New ACCOUNT APPLICATION FORM - PAGE 3");
        getContentPane().setBackground(Color.CYAN);
        setLocation(350,0);
        
        JLabel accdetails = new JLabel("Page 3: Account Details");
        accdetails.setFont(new Font("Raleway",Font.BOLD,22));
        accdetails.setBounds(280,40,400, 40);
        add(accdetails);


        JLabel type = new JLabel("Account type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200, 30);
        add(type);

        sacc = new JRadioButton("Saving Account");
        sacc.setFont(new Font("Raleway",Font.BOLD,16));
        sacc.setBackground(Color.cyan);
        sacc.setBounds(100, 180, 150, 30);
        add(sacc);

        facc = new JRadioButton("Fixed Deposit Account");
        facc.setFont(new Font("Raleway",Font.BOLD,16));
        facc.setBackground(Color.cyan);
        facc.setBounds(350, 180, 200, 30);
        add(facc);

        cacc = new JRadioButton("Current Account");
        cacc.setFont(new Font("Raleway",Font.BOLD,16));
        cacc.setBackground(Color.cyan);
        cacc.setBounds(100, 210, 200, 30);
        add(cacc);

        racc = new JRadioButton("Reccuring Deposit Account");
        racc.setFont(new Font("Raleway",Font.BOLD,16));
        racc.setBackground(Color.cyan);
        racc.setBounds(350, 210, 250, 30);
        add(racc);

        ButtonGroup acc = new ButtonGroup();
        acc.add(sacc); 
        acc.add(facc);
        acc.add(cacc);
        acc.add(racc);
        
        JLabel card = new JLabel("Card Number ");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-0708");  // dummy card number
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300, 30);
        add(number);

        JLabel carddetail = new JLabel("Your 16-digit card number");  // dummy card number
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,300, 15);
        add(carddetail);


        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");  // dummy card number
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300, 30);
        add(pnumber);

        JLabel pindetail = new JLabel("Your 4-digit pin");  // dummy card number
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,300, 15);
        add(pindetail);

        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,250, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.cyan);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.cyan);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.cyan);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Atterts");
        c4.setBackground(Color.cyan);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.cyan);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.cyan);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.cyan);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,630,550,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,660,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,660,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(sacc.isSelected()){
                accountType = "Saving Account";
            }else if(facc.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(cacc.isSelected()){
                accountType = "Current Account";
            }else if(racc.isSelected()){
                accountType = "Reccuring Deposit Account";
            }

            Random random = new Random();
            // gen card num
            String cardnumber = ""+Math.abs((random.nextLong() % 90000000L) + 5040936000000000L); 
            // gen pin num
            String pinnumber = ""+Math.abs((random.nextLong()%9000L)+1000L);

            String facility = "";
            if(c1.isSelected()){
                facility = facility + " Atm Card";
            }else if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility + " EMAIL & SMS Alerts";
            }else if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }else if(c6.isSelected()){
                facility = facility + " E-Statment";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type Required");
                }else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number "+ cardnumber + "\nPin: " + pinnumber);
                    // signup three object
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }    
}
 