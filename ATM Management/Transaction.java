import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiery,exit;
    String pinnumber;

    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setSize(800,800);
        setLocation(300,0);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm_image3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, -50, 800, 800);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(220, 250,700, 35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 345, 150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawal");
        withdrawl.setBounds(350, 345, 140,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 375, 150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(350, 375, 140,25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 405, 150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiery = new JButton("Balance Enquiery");
        balanceenquiery.setBounds(350, 405, 140,25);
        balanceenquiery.addActionListener(this);
        image.add(balanceenquiery);

        exit = new JButton("Exit");
        exit.setBounds(350, 435, 140,25);
        exit.addActionListener(this);
        image.add(exit);

        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false); 
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balanceenquiery){
            setVisible(false);
            new balanceenq(pinnumber).setVisible(true);
        }else if(ae.getSource() == ministatement){
            new ministatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}

