import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.ResultSet;

class Fastcash extends JFrame implements ActionListener{

    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiery,exit;
    String pinnumber;

    Fastcash(String pinnumber){
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

        JLabel text = new JLabel("select your withdrawal amount");
        text.setBounds(220, 250,700, 35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 345, 150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(350, 345, 140,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 375, 150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(350, 375, 140,25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170, 405, 150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiery = new JButton("Rs 10000");
        balanceenquiery.setBounds(350, 405, 140,25);
        balanceenquiery.addActionListener(this);
        image.add(balanceenquiery);

        exit = new JButton("Back");
        exit.setBounds(350, 435, 140,25);
        exit.addActionListener(this);
        image.add(exit);

        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3); // eg. 500
            Conn c= new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+ " Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }

        }
    }
    public static void main(String[] args) {
        new Fastcash("");
    }
}
