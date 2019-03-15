/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipper;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author UCHIHA
 */
public class Console extends JFrame implements ActionListener{
  Container c;
  JButton zip,cancel,choose;
  JLabel file,head;
  
  public  Console()
    {
        c=this.getContentPane();
        
       //BOX LAYOUT
       
        Box horiz1=Box.createHorizontalBox();//first horizontal box
             head=new JLabel("head");
             horiz1.add(head);
             
             Box horiz2=Box.createHorizontalBox(); //second horizontal box
             choose=new JButton("Choose");
             horiz2.add(choose);
                
             Box horiz3=Box.createHorizontalBox();// third vertical box
                zip=new JButton("ZIP IT");
                cancel=new JButton("CANCEL");
                  horiz3.add(zip);
                  horiz3.add(Box.createHorizontalGlue());
                  horiz3.add(cancel);
                  
              Box vert=Box.createVerticalBox();//vertical box
                  vert.add(horiz1);
                  horiz2.add(Box.createVerticalGlue());
                  vert.add(horiz2);
                  horiz2.add(Box.createVerticalGlue());
                  vert.add(horiz3);
                  
                  c.add(vert);//adding elements to content pane
                  
                  choose.addActionListener(this);
                  zip.addActionListener(this);
                  cancel.addActionListener(this);
        
    }
  
public  void open()
  {
      JFileChooser jfc=new JFileChooser();
       int i=jfc.showOpenDialog(this);
       
       if(i==JFileChooser.APPROVE_OPTION)
       {
           File f=jfc.getSelectedFile();
           String fname=f.getPath();
           System.out.println(fname);
       }
  }
  
  @Override  
public  void actionPerformed(ActionEvent ae)
  {
      String s=ae.getActionCommand();
      if(s.equals("Choose")) this.open();
  }
}
