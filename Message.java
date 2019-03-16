/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipper;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author UCHIHA
 */
public class Message extends JPanel implements ActionListener {
    
    JButton mess;
    JLabel message;
    Console cns;
    
    public Message(Console c)
    { 
        cns=c;
        Box b0=Box.createVerticalBox();
            Box hb=Box.createHorizontalBox();
            message=new JLabel("Successful!");//Label
             hb.add(message);
             b0.add(hb);
        
        Box b1=Box.createVerticalBox();
         Box hb1=Box.createHorizontalBox();
            mess=new JButton("BACK");  //back button
             hb1.add(mess);
             b1.add(hb1);
             
             Box b3=Box.createVerticalBox();
              b3.add(Box.createVerticalStrut(10));
              b3.add(b0);
              b3.add(Box.createVerticalStrut(10));
              b3.add(b1);
              
              this.add(b3);//adding elements to Jpanel
              
              mess.addActionListener(this);
              
        
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        cns.cl.show(cns.c,"OPTION");//back button is pressed
    }
    
}
