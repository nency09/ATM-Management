import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class pinchange extends JFrame implements ActionListener{

    JLabel text,pintext,repintext;
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;

    pinchange(String pinnumber){

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

        text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 250,700, 35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        pintext = new JLabel("New PIN:");
        pintext.setBounds(170, 290,700, 25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,290,150,25);
        image. add(pin);

        repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(170, 330,650, 25);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,330,150,25);
        image. add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(330,400,150,25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(330,430,150,25);
        back.addActionListener(this);
        image.add(back);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered pin does not match");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter new pin");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter pin");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"'where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"'where pin = '"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"'where pin = '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN Changed Successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            }catch(Exception e){
            System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new pinchange("");
    }
}
