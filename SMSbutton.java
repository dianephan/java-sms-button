// HAVE TO RUN `source ./twilio.env`
// THEN 
// java -cp .:twilio-8.8.0-jar-with-dependencies.jar SMSButton

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class SMSEventClicker implements ActionListener {
    JFrame frame=new JFrame();
    JButton button=new JButton("Click Me");
 
    SMSEventClicker(){
        createButtonGUI();
        buttonProperties();
    }
    public void createButtonGUI(){
        frame.setTitle("Send an SMS");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(400,400,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void buttonProperties(){
        button.setBounds(150,150,150,150);   
        frame.add(button);
        button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Message message = Message
            .creator(new PhoneNumber("+<YOUR_PHONE_NUMBER>"), // to 
                    new PhoneNumber("+<YOUR_TWILIO_NUMBER>"), // from
                    "Ahoy ahoy!")
            .create();
        System.out.println(message.getSid());
    }
}
 
public class SMSButton {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        new SMSEventClicker();
    }
}
