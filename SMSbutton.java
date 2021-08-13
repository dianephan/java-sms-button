// HAVE TO RUN `source ./twilio.env`
// THEN 
// java -cp .:twilio-8.8.0-jar-with-dependencies.jar SMSbutton

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

//importing all necessary packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


class ActionEventDemo implements ActionListener {
    JFrame frame=new JFrame();
    JButton button=new JButton("Click Me");//Creating object of JButton class
 
    ActionEventDemo(){
        prepareGUI();
        buttonProperties();//Calling buttonProperties() method
    }
 
    public void prepareGUI(){
        frame.setTitle("My Window");//Setting title of JFrame
        frame.getContentPane().setLayout(null);//Setting Layout
        frame.setVisible(true);//Setting visibility
        frame.setBounds(200,200,400,400);//Setting Location and Size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Setting default close operation
    }
    public void buttonProperties(){
        button.setBounds(130,200,100,40);   //Setting location and size of button
        frame.add(button);                  //adding button to the frame
        button.addActionListener(this);
    }
    
    //Overriding actionPerformed() method
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().setBackground(Color.pink);
        // send msg here
        Message message = Message
            .creator(new PhoneNumber("+14088001685"), // to (my text now number doesnt work idk why)
                    new PhoneNumber("+19145296977"), // from
                    "Wwasssup twilio is yaboi aussie gamer?")
            .create();

        System.out.println(message.getSid());


    }
}
 
public class SMSbutton {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        new ActionEventDemo();//Creating object of ActionEventDemo class
    }
}
