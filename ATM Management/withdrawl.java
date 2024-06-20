import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

class withdrawl extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw,back;
    String pinnumber;

    withdrawl(String pinnumber) {
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

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("Syste,",Font.BOLD,16));
        text.setBounds(170,250,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22)); 
        amount.setBounds(170,300 ,320 ,25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(350,405,140,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(350,435,140,25);
        back.addActionListener(this);
        image.add(back);




        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();

            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount you want to withdraw");
            }else{
                
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+number+"')";
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(rs.getString("amount"));
                        }else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    // if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    // JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    // return;
                
                    conn.s.executeUpdate(query);
                } catch (Exception e) {
                    System.out.println(e);
                }

                
                JOptionPane.showMessageDialog(null,"Rs "+number+" withdraw Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new withdrawl("");
    }
}
