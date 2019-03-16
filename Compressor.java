/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipper;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;


/**
 *
 * @author UCHIHA
 */
public class Compressor extends JPanel implements ActionListener{
  //Container c;
  JButton zip,cancel,choose;
  JLabel file,head,fn;
  String fname;
  Console cons;
  int flag;
  public  Compressor(Console c)
    {
        cons=c;
        
       //BOX LAYOUT
       
        Box horiz1=Box.createVerticalBox();//first vertical box
              Box h0=Box.createHorizontalBox();
             head=new JLabel("ZIP FILE");
             h0.add(head);
             horiz1.add(h0);
             
             Box horiz2=Box.createVerticalBox(); //second vertical box
                   Box h1=Box.createHorizontalBox();
                   
                   choose=new JButton("Choose");
                   fn=new JLabel("nofile");
                   h1.add(choose);
                   h1.add(fn);
                    horiz2.add(h1);
                
             Box horiz3=Box.createVerticalBox();// third vertical box
                   Box h2=Box.createHorizontalBox();
                zip=new JButton("ZIPIT");//button zipit
                cancel=new JButton("CANCEL");  //cancel button
                  h2.add(zip);
                  h2.add(Box.createHorizontalStrut(40));
                  h2.add(cancel);
                  horiz3.add(h2);
                  
              Box vert=Box.createVerticalBox();//final vertical box
                  vert.add(horiz1);
                  vert.add(Box.createVerticalStrut(20));
                  vert.add(horiz2);
                 vert.add(Box.createVerticalStrut(40));
                  vert.add(horiz3);
                  
              this.add(vert);//adding elements to Jpanel
                  
                  choose.addActionListener(this);
                  zip.addActionListener(this);
                  cancel.addActionListener(this);
        
    }
  
  //method to compress
  public int compress(String fname)
  {
      try{
         
               Zipping zipo=new Zipping(fname);
                 zipo.zip();
          
       }catch(IOException ie)
       {
           System.out.print(ie);
           return 0;//if fails
       }
      return 1;//if success
  }
  
 
 
   //open a file Chooser
public  void open()
  {
      JFileChooser jfc=new JFileChooser();
       int i=jfc.showOpenDialog(this);
    
       if(i==JFileChooser.APPROVE_OPTION)
       {
           File f=jfc.getSelectedFile();
           fname=f.getPath();
           fn.setText(fname);
        
  
       }else
       {
             fname=null;
           
       }
       
  }
  
  @Override  
public  void actionPerformed(ActionEvent ae)
  {
      
      String s=ae.getActionCommand();
      
      if(s.equals("Choose")) this.open();//choosing file
            
      if(s.equals("ZIPIT")) //zipping file
      {
          if(fname!=null) 
          {
              flag=this.compress(fname);
              if(flag==1)
              {
                  cons.cl.show(cons.c,"MESSAGE");//opening successful message
              }
          }
      }
      
      if(s.equals("CANCEL"))cons.cl.show(cons.c,"OPTION");//going back
      
          
           
      
      
      
  }
}
