import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
class balanceenq extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    balanceenq(String pinnumber){

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

        back = new JButton("BACK");
        back.setBounds(330,430,150,25);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }

        JLabel text = new JLabel("Your Current Account Balance is: "+balance);
        text.setBounds(170,250,400,30);
        image.add(text);

        //setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String[] args) {
        new balanceenq("");
    }
}
