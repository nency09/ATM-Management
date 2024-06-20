import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener {  // by ActionListener you can make actions by clicking on the particular button

    // we have to define the buttons globally so we can use them in other methods()
    JButton login,signup,clear; 
    JTextField cardTextField;
    JPasswordField pinTextField;  // will hide wht you write

    Login(){

        setLayout(null);  // by default : center
        
        setSize(800,480);  // this is use to set length and breadth of the frame
        
        setLocation(280, 100); // 350 from left | 200 from right [by default --> top left]

        // how to set title at centre?//
        setTitle("AUTOMATED TELLER MACHINE");

        getContentPane().setBackground(Color.cyan);        // getContentPane is to use the full frame | setBackground is a method | Color class

        
         

        ImageIcon i01 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image i2 = i01.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT); // awt package
        ImageIcon i3 = new ImageIcon(i2); //converting image into image icon bcz Jlabel
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);   //x(left),y(top),width,length (to coustomize the layout)
        add(label);

        // LABEL-1(TEXT)   --> WELCOME

        // To write anything on the frame we use Jlabel
        JLabel text = new JLabel("Welcome to ATM Machine");  // its not yet visible on the frame- you have to define loc
        text.setFont(new Font("Osward",Font.BOLD,38));  // fontname-fonttype-fontsize
        text.setBounds(200, 40, 600, 40);
        add(text); // its not yet visible on the frame- you have to define loc - bcz default is set to null

        // LABEL-2(TEXT)   --> cardnumber

        JLabel cardno = new JLabel("Card No: ");  // its not yet visible on the frame- you have to define loc
        cardno.setFont(new Font("Raleway",Font.BOLD,28));  // fontname-fonttype-fontsize
        cardno.setBounds(120, 150, 150, 30);
        add(cardno); // its not yet visible on the frame- you have to define loc - bcz default is set to null

        //TEXTFIELD-1 (Cardno) FOR TAKING INPUT FROM THE USER

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);  // height same as cardno | cardno height should be equal to textField
        cardTextField.setFont(new Font("Ariel",Font.BOLD,14));
        add(cardTextField);

        // LABEL-3(TEXT)   --> PIN

        JLabel pin = new JLabel("PIN: ");  // its not yet visible on the frame- you have to define loc
        pin.setFont(new Font("Osward",Font.BOLD,28));  // fontname-fonttype-fontsize
        pin.setBounds(120, 220, 250, 30);
        pin.setFont(new Font("Ariel",Font.BOLD,28));
        add(pin); // its not yet visible on the frame- you have to define loc - bcz default is set to null

        //TEXTFIELD-2 (pinno) FOR TAKING INPUT FROM THE USER

        pinTextField =  new JPasswordField();
        pinTextField.setBounds(300,220,230,30);  // height same as cardno | cardno height should be equal to textField
        add(pinTextField);


        // CREATING BUTTONS

        // Button - 1  [sign in]
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);  // this will notify that the button has been pressed.
        add(login);

        // Button - 2  [clear]
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);  // this will notify that the button has been pressed.
        add(clear);

        // Button - 3  [signup]
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);  // 530 - 300 = 230
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);  // this will notify that the button has been pressed.
        add(signup);

        //    KEEP setVisibility AT LAST    //
        setVisible(true);  // this is used to see the frame(by default : false)
    }

    @Override
    public void actionPerformed(ActionEvent ae){  // ActionEvent differentiate between buttons(components)
        // when button is clicked what we have to do is programmed in this method.
        // getSource = which button
        if (ae.getSource() == clear) {  // true- empty 

            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"'and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            setVisible(false);
        } else if (ae.getSource() == signup) {
            setVisible(false);  //current frame 
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login(); 
    }

}
